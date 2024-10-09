import openai
import numpy as np
import faiss
from dotenv import load_dotenv
import os
from typing import List, Tuple

load_dotenv()
openai.api_key = os.getenv('OPENAI_API_KEY')

# Prepare sample documents


documents = [
    "The quick brown fox jumps over the lazy dog",
    "Machine learning is a subset of artificial intelligence",
    "Python is a popular programming language",
    "Natural language processing helps computers understand human language",
    "Vector databases are optimized for similarity search operations"
]

# Function to generate embeddings using OpenAI

def create_embeddings(texts: List[str]) -> np.ndarray:
    """
    Generate embeddings for a list of texts using OpenAI's API
    """
    try:
        response = openai.Embedding.create(
            input=texts,
            model="text-embedding-ada-002"
        )
        embeddings = [embedding['embedding'] for embedding in response['data']]
        return np.array(embeddings).astype('float32')
    except Exception as e:
        print(f"Error generating embeddings: {e}")
        raise

# Initialize and populate FAISS index

def initialize_vector_db(embeddings: np.ndarray) -> faiss.IndexFlatIP:
    """
    Initialize FAISS index with cosine similarity
    Note: IndexFlatIP is used for cosine similarity when vectors are normalized
    """
    dimension = embeddings.shape[1]
    
    index = faiss.IndexFlatIP(dimension)
    
    faiss.normalize_L2(embeddings)
    
    index.add(embeddings)
    
    print(f"Vector database initialized with {len(embeddings)} vectors of dimension {dimension}")
    return index

# Function to perform similarity search

def cosine_similarity_search(
    query: str,
    index: faiss.IndexFlatIP,
    documents: List[str],
    n_results: int = 3
) -> List[Tuple[str, float]]:
    """
    Perform cosine similarity search for a query
    Returns list of (document, similarity_score) tuples
    """
    query_embedding = create_embeddings([query])[0]
    
    query_embedding = query_embedding.reshape(1, -1)
    faiss.normalize_L2(query_embedding)
    
    similarities, indices = index.search(query_embedding, n_results)
    
    results = [
        (documents[idx], float(score))
        for idx, score in zip(indices[0], similarities[0])
    ]
    
    return results


# Main execution

print("Generating embeddings...")
embeddings = create_embeddings(documents)

print("Initializing vector database...")
index = initialize_vector_db(embeddings)

def search_documents(query: str, n_results: int = 3):
    """
    Search for similar documents and display results
    """
    results = cosine_similarity_search(query, index, documents, n_results)
    
    print(f"\nQuery: {query}")
    print("\nMost similar documents:")
    for doc, score in results:
        print(f"- Score {score:.4f}: {doc}")

query = "What is artificial intelligence?"
search_documents(query)



