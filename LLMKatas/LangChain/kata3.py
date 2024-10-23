import os
from dotenv import load_dotenv
from langchain import OpenAI
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores import FAISS
from langchain.text_splitter import CharacterTextSplitter
from langchain.chains import RetrievalQA
from langchain.docstore.document import Document

# Load environment variables
load_dotenv()
api_key = os.getenv('OPENAI_API_KEY')
os.environ["OPENAI_API_KEY"] = api_key

# Load documents from an external text file
def load_documents(file_path):
    """Load documents from a text file and return a list of strings."""
    with open(file_path, 'r', encoding='utf-8') as file:
        return file.readlines()

file_path = 'kata3.txt'

# Read documents and convert them to LangChain's Document format
try:
    documents = load_documents(file_path)
    docs = [Document(page_content=text.strip()) for text in documents if text.strip()]
except Exception as e:
    print(f"Error loading documents: {e}")
    docs = []

if not docs:
    raise ValueError("No documents found. Please check the file path or contents.")

# Split documents into smaller chunks
text_splitter = CharacterTextSplitter(chunk_size=1000, chunk_overlap=0)
texts = text_splitter.split_documents(docs)

# Create the vector store using OpenAI embeddings
embeddings = OpenAIEmbeddings()
vectorstore = FAISS.from_documents(texts, embeddings)

# Create the retrieval-based QA chain
qa = RetrievalQA.from_chain_type(
    llm=OpenAI(),
    chain_type="stuff",
    retriever=vectorstore.as_retriever()
)

def answer_question(question):
    """Answer a question using the QA chain."""
    return qa.run(question)

questions = [
    "What is Gemini AI?",
    "Who won the latest T20 World Cup?",
    "Tell me about Black Myth: Wukong game?",
    "Tell me about Virat Kohli?"
]

for question in questions:
    try:
        answer = answer_question(question)
        print(f"Question: {question}")
        print(f"Answer: {answer}\n")
    except Exception as e:
        print(f"Error answering question '{question}': {e}")
