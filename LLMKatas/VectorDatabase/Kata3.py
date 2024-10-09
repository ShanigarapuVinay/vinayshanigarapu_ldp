import openai
import numpy as np
import faiss
from dotenv import load_dotenv
import os

load_dotenv()
openai.api_key = os.getenv('OPENAI_API_KEY')

# Prepare the document corpus

documents = [
    "Python is a high-level programming language known for its simplicity and readability.",
    "Machine learning is a subset of artificial intelligence that focuses on data and algorithms.",
    "Natural Language Processing (NLP) enables computers to understand human language.",
    "Deep learning models can automatically learn representations from data.",
    "Vector databases are specialized databases for storing and retrieving vector embeddings."
]

# Generate embeddings for the document corpus

def generate_embeddings(texts):
    response = openai.Embedding.create(
        input=texts,
        model="text-embedding-ada-002"
    )
    return [embedding['embedding'] for embedding in response['data']]

print("Generating embeddings for documents...")
document_embeddings = generate_embeddings(documents)

# Store embeddings in FAISS vector database

dimension = len(document_embeddings[0])
index = faiss.IndexFlatL2(dimension)
document_embeddings_array = np.array(document_embeddings).astype('float32')
index.add(document_embeddings_array)
print(f"Vector database created with {len(documents)} documents")

# Function to retrieve relevant documents

def get_relevant_context(query, k=2):
    # Generate embedding for the query
    query_embedding = generate_embeddings([query])[0]
    query_array = np.array([query_embedding]).astype('float32')
    
    # Search in vector database
    distances, indices = index.search(query_array, k)
    
    # Get relevant documents
    relevant_docs = [documents[i] for i in indices[0]]
    return relevant_docs

# Function to generate chatbot response

def generate_response(query):
    # Get relevant documents
    relevant_context = get_relevant_context(query)
    
    # Prepare prompt with context
    prompt = f"""Use the following context to answer the question. 
    If the context doesn't contain relevant information, say so.
    
    Context: {' '.join(relevant_context)}
    
    Question: {query}
    
    Answer:"""
    
    # Generate response using ChatGPT
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "You are a helpful assistant that answers questions based on the provided context."},
            {"role": "user", "content": prompt}
        ],
        temperature=0.7
    )
    
    return {
        'answer': response.choices[0].message['content'],
        'relevant_documents': relevant_context
    }

# Interactive chatbot interface

def chat():
    print("Chatbot initialized. Type 'quit' to exit.")
    while True:
        query = input("\nYou: ").strip()
        if query.lower() == 'quit':
            break
            
        result = generate_response(query)
        print("\nChatbot:", result['answer'])
        print("\nRelevant documents used:")
        for doc in result['relevant_documents']:
            print(f"- {doc}")

if __name__ == "__main__":
    chat()