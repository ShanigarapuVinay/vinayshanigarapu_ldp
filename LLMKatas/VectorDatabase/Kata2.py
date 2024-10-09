# Create Pinecone client

import os
import pinecone
import openai
import pandas as pd
from dotenv import load_dotenv
from pinecone import Pinecone, ServerlessSpec

load_dotenv()

openai.api_key = os.getenv('OPENAI_API_KEY')

pc = pinecone.Pinecone(
    api_key=os.getenv("PINECONE_API_KEY")
)

# Check if the index exists, if not, create it

index_name = "hybrid-search"

if index_name not in pc.list_indexes().names():
    pc.create_index(
        name=index_name,
        dimension=1536,
        metric="cosine",
        spec=ServerlessSpec(
            cloud="aws",
            region="us-east-1"
        ) 
    )

existing_indexes = pc.list_indexes()
print("Existing indexes:", existing_indexes)

# Check if the index exists and delete it

if index_name in pc.list_indexes().names():
    pc.delete_index(index_name)
    print(f"Index {index_name} deleted.")


index = pc.Index(index_name)

# Sample documents with metadata

documents = [
    {
        "title": "Introduction to Machine Learning",
        "content": "Machine learning is a subset of artificial intelligence that focuses on data and algorithms.",
        "author": "John Smith",
        "date": "2024-01-15",
        "category": "AI"
    },
    {
        "title": "Python Programming Basics",
        "content": "Python is a high-level programming language known for its simplicity.",
        "author": "Jane Doe",
        "date": "2024-02-20",
        "category": "Programming"
    },
    {
        "title": "Deep Learning Fundamentals",
        "content": "Deep learning is a subset of machine learning using neural networks.",
        "author": "John Smith",
        "date": "2024-03-10",
        "category": "AI"
    },
    {
        "title": "Data Structures in Python",
        "content": "Understanding data structures is crucial for efficient programming.",
        "author": "Jane Doe",
        "date": "2024-03-15",
        "category": "Programming"
    }
]

# Function to create embeddings using OpenAI API

def create_embeddings(texts):
    response = openai.Embedding.create(input=texts, model="text-embedding-ada-002")
    return [item['embedding'] for item in response['data']]

# Generate embeddings for the document content
contents = [doc['content'] for doc in documents]
embeddings = create_embeddings(contents)

# Upsert documents into Pinecone with metadata
for doc, embedding in zip(documents, embeddings):
    metadata = {k: doc[k] for k in ['title', 'author', 'date', 'category']}
    index.upsert(vectors=[(doc['title'], embedding, metadata)])

print("Documents and embeddings uploaded to Pinecone.")


# Implement the Hybrid Search Function

def hybrid_search(query, metadata_filters=None, top_k=3):
    # Step 1: Filter documents by metadata
    query_filter = {}
    if metadata_filters:
        query_filter = {k: {"$eq": v} for k, v in metadata_filters.items()}

    # Step 2: Create embedding for the query
    query_embedding = create_embeddings([query])[0]

    # Step 3: Perform vector search with metadata filtering
    results = index.query(
        vector=query_embedding,
        top_k=top_k,
        filter=query_filter,
        include_metadata=True
    )
    
    # Step 4: Return the ranked results
    return results

query = "machine learning concepts"
metadata_filters = {"author": "John Smith", "category": "AI"}


results = hybrid_search(query, metadata_filters)
print("\nResults:")
for match in results['matches']:
    print(f"Title: {match['metadata']['title']}, Author: {match['metadata']['author']}, Similarity: {match['score']:.4f}")



