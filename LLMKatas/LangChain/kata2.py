import openai
from langchain.chat_models import ChatOpenAI
from langchain import PromptTemplate, LLMChain
from dotenv import load_dotenv
import os

load_dotenv()
api_key = os.getenv('OPENAI_API_KEY')

llm = ChatOpenAI(temperature=0.7, openai_api_key=api_key)

# Create a prompt template that encourages Chain of Thought reasoning
cot_prompt = """
You are a reasoning assistant. For every query, you will break down your thought process into step-by-step reasoning before providing the final answer.

Query: {question}
Step-by-step reasoning:
"""

# Set up the LLM chain with the prompt template
prompt = PromptTemplate(template=cot_prompt, input_variables=["question"])
llm_chain = LLMChain(llm=llm, prompt=prompt)

# Function to interact with the system using Chain of Thought reasoning
def ask_with_reasoning(query):
    return llm_chain.run(question=query)

print(ask_with_reasoning("What is 25 times 13?"))

print(ask_with_reasoning("If all men are mortal, and Socrates is a man, is Socrates mortal?"))
