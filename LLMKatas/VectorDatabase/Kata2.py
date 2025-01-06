import os
import pinecone
import openai
from dotenv import load_dotenv
from typing import List, Dict

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
        spec=pinecone.ServerlessSpec(
            cloud="aws",
            region="us-east-1"
        )
    )

index = pc.Index(index_name)

# Function to load documents and metadata from a .txt file
def load_documents_from_txt(file_path: str) -> List[Dict]:
    documents = []
    with open(file_path, 'r', encoding='utf-8') as file:
        lines = file.readlines()

    for line in lines:
        parts = line.strip().split(',')
        if len(parts) == 5:
            doc = {
                "title": parts[0].strip(),
                "content": parts[1].strip(),
                "author": parts[2].strip(),
                "date": parts[3].strip(),
                "category": parts[4].strip()
            }
            documents.append(doc)
    return documents

documents = load_documents_from_txt('kata2.txt')

# Create embeddings using OpenAI API
def create_embeddings(texts):
    response = openai.Embedding.create(input=texts, model="text-embedding-ada-002")
    return [item['embedding'] for item in response['data']]

# Generate embeddings for document content
contents = [doc['content'] for doc in documents]
embeddings = create_embeddings(contents)

# Upsert documents into Pinecone with metadata
for doc, embedding in zip(documents, embeddings):
    metadata = {k: doc[k] for k in ['title', 'author', 'date', 'category']}
    index.upsert(vectors=[(doc['title'], embedding, metadata)])

print("Documents and embeddings uploaded to Pinecone.")

# Hybrid search with simultaneous filtering and embedding
def hybrid_search(query, metadata_filters=None, top_k=3):
    query_embedding = create_embeddings([query])[0]

    # Combine filter and embedding in the query
    query_filter = {}
    if metadata_filters:
        query_filter = {k: {"$eq": v} for k, v in metadata_filters.items()}

    results = index.query(
        vector=query_embedding,
        top_k=top_k,
        filter=query_filter,
        include_metadata=True
    )

    return results

# Example query
query = "machine learning concepts"
metadata_filters = {"author": "John Smith", "category": "AI"}

# Perform hybrid search
results = hybrid_search(query, metadata_filters)
print("\nResults:")
for match in results['matches']:
    print(f"Title: {match['metadata']['title']}, Author: {match['metadata']['author']}, Similarity: {match['score']:.4f}")
