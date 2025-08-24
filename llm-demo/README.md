
## DeepSeek4j
~~~
https://gitee.com/jason-lh/deepseek4j/tree/main
~~~

## LangChain4j
~~~
dev.langchain4j.service.AiServices
<dependency>
            <groupId>dev.langchain4j</groupId>
            <artifactId>langchain4j-spring-boot-starter</artifactId>
            <version>1.3.0-beta9</version>
</dependency>
~~~
- AiServices: AiServices会组装Assistant接口以及其他组件，并使用反射机制创建一个实现Assistant接口的代理对象。这个代理对象会处理输入和输出的所有转换工作。在这个例子中，chat方法的输入是一个字符串，但是大模型需要一个UserMessage对象。所以，代理对象将这个字符串转换为UserMessage，并调用聊天语言模型。chat方法的输出类型也是字符串，但是大模型返回的是AiMessage对象，代理对象会将其转换为字符串。
简单理解就是：代理对象的作用是输入转换和输出转换.
- 聊天记忆
- 隔离聊天记忆
- 持久化聊天记忆
- 提示词Prompt-系统提示词模版：用注解@SystemMessage 设定角色，塑造AI助手的专业身份，明确助手的能力范围。
- 提示词Prompt-用户提示词模版：用注解@UserMessage：获取用户输入
- 提示词Prompt-配置@V注解
- Function Calling 函数调用：也叫 Tools（@Tool、@P和@ToolMemoryId注解） 工具。例如，大语言模型本身并不擅长数学运算。如果应用场景中偶尔会涉及到数学计算，我们可以为他提供一个 “数学工具”。当我们提出问题时，大语言模型会判断是否使用某个工具。用 @Tool 注解的方法，既可以是静态的，也可以是非静态的；
- Function Calling 函数调用-ToolMemoryId注解：如果你的 AiService 方法中有一个参数使用 @MemoryId 注解，那么你也可以使用 @ToolMemoryId 注解 @Tool 方法中的一个参数。提供给 AiService 方法的值将自动传递给 @Tool 方法。如果你有多个用户，或每个用户有多个聊天记忆，并且希望在 @Tool 方法中对它们进行区分，那么这个功能会很有用。
- _微调：在现有大模型的基础上，使用小规模的特定任务数据进行再次训练，调整模型参数，让模型更精确地处理特定领域或任务的数据。更新需重新训练，计算资源和时间成本高。_
- RAG（+知识库）：将原始问题以及提示词信息发送给大语言模型之前，先通过**外部知识库**检索相关信息，然后将检索结果和原始问题一起发送给大模型，大模型依据外部知识库再结合自身的训练数据，组织自然语言回答问题。通过这种方式，大语言模型可以获取到特定领域的相关信息，并能够利用这些信息进行回复。
  - Embedding Model向量模型：Embedding (Vector) Stores 常见的意思是 “嵌入（向量）存储” 。在机器学习和自然语言处理领域，Embedding 指的是将数据（如文本、图像等）转换为低维稠密向量表示的过程，这些向量能够保留数据的关键特征。而 Stores 表示存储，即用于存储这些嵌入向量的系统或工具。它们可以高效地存储和检索向量数据，支持向量相似性搜索，在文本检索、推荐系统、图像识别等任务中发挥着重要作用。
  - token和token计算:
  - 向量模型：~~demo中使用阿里百炼~~的模型；使用`text-embedding-v3`依然需要添加`langchain4j-community-dashscope`依赖；
  - 向量存储：向量存储和相似度比对；Demo之前使用的是InMemoryEmbeddingStore作为向量存储，但是不建议在生产中使用基于内存的向量存储。因此这里可以使用Pinecone作为向量数据库。
  - 流式输出：依赖spring-boot-starter-webflux 和 langchain4j-reactor。
    - #集成阿里通义千问-流式输出，并修改`XiaozhiAgent`中`chatModel`改为 streamingChatModel = "qwenStreamingChatModel"
  - 
## Ollama
~~~
ollama run deepseek-r1:1.5b
~~~

## Python Code for OpenAI
~~~shell
#引入langchain聊天场景的提示词模版
from langchain_core.prompts import ChatPromptTemplate

#引入langchain openai sdk
from langchain_openai import ChatOpenAI
llm = ChatOpenAI()

#根据message生成提示词模版
prompt = ChatPromptTemplate.from_messages([
    ("system", "你是世界级的技术专家"),  #给系统一个提示，告诉模型你的角色或定位（主要任务），以便更好的生成结果。
    ("user", "{input}") #用户输入的提示词，真正的问题内容
])

# 通过langchain的链式调用，生成一个chain
# 创建一个链，将（先生成）提示词模版和（后调用）模型连接起来
chain = prompt | llm
result = chain.invoke({"input": "帮我写一篇关于AI的技术文章，100个字"})
print(result)
~~~

## MongoDB
~~~
{
    "registry-mirrors": [
        "https://docker.m.daocloud.io",
        "https://docker.imgdb.de",
        "https://docker-0.unsee.tech",
        "https://docker.hlmirror.com",
        "https://docker.1ms.run",
        "https://func.ink",
        "https://lispy.org",
        "https://docker.xiaogenban1993.com",
        "https://hub-mirror.c.163.com"
    ]
}
~~~
~~~
docker pull mongodb/mongodb-community-server:latest
docker pull docker.m.daocloud.io/mongodb/mongodb-community-server:latest

docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest
docker container ls

# 使用 mongosh 连接到 MongoDB 部署
docker exec -it mongodb bash
# mongosh --port 27017

~~~

