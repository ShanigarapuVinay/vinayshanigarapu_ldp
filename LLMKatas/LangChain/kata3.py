import os
from dotenv import load_dotenv
from langchain import OpenAI
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores import FAISS
from langchain.text_splitter import CharacterTextSplitter
from langchain.chains import RetrievalQA
from langchain.docstore.document import Document

load_dotenv()

api_key = os.getenv('OPENAI_API_KEY')

os.environ["OPENAI_API_KEY"] = api_key

# Define your inline documents
documents = [
    "India won the T20 World Cup 2024 against South Africa by 7 runs",
    "Google introduced a new family of AI models called Gemini, which are multimodal, meaning they can process text, images, audio, and videos. The Gemini Ultra model outperforms human experts in many benchmark tests and is used in various applications, including the upgraded Google Bard AI and AlphaCode 2 for competitive programming. Gemini models are also integrated into Google Cloud Vertex AI, enabling developers to build complex AI applications.",
    "Black Myth: Wukong is a 2024 action role-playing game developed and published by Game Science. The game is inspired by the classical Chinese novel Journey to the West and follows an anthropomorphic monkey based on Sun Wukong from the novel.",
    "The Opeartion Hydra is collapsing the buildings which are constructed near rivers under the guidance of Revanth Reddy."
]

# Convert these documents to LangChain's Document format
docs = [Document(page_content=text) for text in documents]


# Split documents into smaller chunks (if necessary)
text_splitter = CharacterTextSplitter(chunk_size=1000, chunk_overlap=0)
texts = text_splitter.split_documents(docs)

# Create the vector store
embeddings = OpenAIEmbeddings()
vectorstore = FAISS.from_documents(texts, embeddings)

# Create the retrieval-based QA chain
qa = RetrievalQA.from_chain_type(
    llm=OpenAI(),
    chain_type="stuff",
    retriever=vectorstore.as_retriever()
)

def answer_question(question):
    return qa.run(question)

question = "What is Gemini AI?"
answer = answer_question(question)
print(f"Question: {question}")
print(f"Answer: {answer}")

question = "Who won the latest T20 World Cup?"
answer = answer_question(question)
print(f"Question: {question}")
print(f"Answer: {answer}")

question = "Tell me about Black Myth: Wukong game?"
answer = answer_question(question)
print(f"Question: {question}")
print(f"Answer: {answer}")

question = "Tell me about Virat Kohli?"
answer = answer_question(question)
print(f"Question: {question}")
print(f"Answer: {answer}")
