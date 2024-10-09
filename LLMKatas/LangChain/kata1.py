import openai
from langchain.chat_models import ChatOpenAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
from langchain.prompts import PromptTemplate
from dotenv import load_dotenv

import os

load_dotenv()
api_key = os.getenv('OPENAI_API_KEY')

llm = ChatOpenAI(model_name="gpt-4o", temperature=0.7, openai_api_key=api_key)

# Initialize ConversationBufferMemory
memory = ConversationBufferMemory(return_messages=True)

# Create custom prompt template
template = """You are a friendly and helpful AI assistant that remembers our conversation.
Please provide engaging and informative responses while maintaining context.

Current conversation:
{history}
Human: {input}
AI Assistant:"""

prompt = PromptTemplate(
    input_variables=["history", "input"],
    template=template
)


# Initialize the conversation chain
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    prompt=prompt,
    verbose=True
)

def chat(user_input):
    """Simple function to get response from chatbot"""
    return conversation.predict(input=user_input)

if __name__ == "__main__":
    while True:
        user_input = input("\nYou: ")
        if user_input.lower() in ['quit', 'exit', 'bye']:
            print("Goodbye!")
            break
        response = chat(user_input)
        print("\nAssistant:", response)



