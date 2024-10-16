import fitz
from langchain.chains import RetrievalQA
from langchain_community.chat_models import ChatOpenAI
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores import FAISS
from langchain.text_splitter import RecursiveCharacterTextSplitter
from dotenv import load_dotenv
import os
import openai

load_dotenv()
openai.api_key = os.getenv('OPENAI_API_KEY')

def extract_text_from_pdf(pdf_path):
    text = ""
    with fitz.open(pdf_path) as pdf_document:
        for page in pdf_document:
            text += page.get_text()
    return text

pdf_path = "budget_speech.pdf"
pdf_text = extract_text_from_pdf(pdf_path)

splitter = RecursiveCharacterTextSplitter(chunk_size=1000, chunk_overlap=100)
chunks = splitter.split_text(pdf_text)

embeddings = OpenAIEmbeddings()
vector_db = FAISS.from_texts(chunks, embeddings)

llm = ChatOpenAI(model_name="gpt-3.5-turbo-1106", temperature=0)

qa_chain = RetrievalQA.from_chain_type(llm=llm, chain_type="stuff", retriever=vector_db.as_retriever())

def chatbot_interface(user_query):
    response = qa_chain.invoke({"query": user_query})
    return response.get('result', 'No answer found.')

def start_chatbot():
    print("Welcome to the PDF Chatbot! Type 'exit' to end the chat.")
    while True:
        query = input("\nYou: ")
        if query.lower() == 'exit':
            print("Goodbye!")
            break
        response = chatbot_interface(query)
        print(f"Chatbot: {response}")

start_chatbot()

