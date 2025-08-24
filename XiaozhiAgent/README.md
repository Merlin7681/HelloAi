# 项目实战-优化硅谷小智

## 基础知识

**LangChain基本概念**：
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
用于对接本地LLM
~~~
ollama run deepseek-r1:1.5b
~~~

## 前后端分离的接口测试工具
~~~xml
 <!-- 前后端分离中的后端接口测试工具 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
            <version>${knife4j.version}</version>
        </dependency>
~~~
访问 http://localhost:8080/doc.html 查看程序能否成功运行并显示如下页面

## AI测试
~~~
http://localhost:8080/xiaozhi/chat2?memoryId=10&message=大有北里怎么走
http://localhost:8080/xiaozhi/chat2?memoryId=10&message=我想预约明天上午的神经内科
http://localhost:8080/xiaozhi/chat2?memoryId=10&message=姓名是王武，身份证111101112123304040，预约明天
http://localhost:8080/xiaozhi/chat2?memoryId=10&message=确认

http://localhost:8080/doc.html
http://localhost:8080/xiaozhi/chat2?memoryId=10&message=你好，我头疼 应该怎么处理？
{"memoryId": 10, "message": "姓名：姚翠花、230104190000000000、神经内科、明天下午，最好的医生。"}
{"memoryId": 1, "message": "医院的位置在哪，神经内科怎么找"}

~~~

## Reference

- Maven Respository：https://mvnrepository.com/

- **Demo参考文档**：尚硅谷-Java+大模型-硅谷小智（医疗版）.md

**从零打造AI面试系统**

- [从零打造AI面试系统全栈开发](https://blog.csdn.net/Joseit/article/details/148411644)
- [Github-AI Interviewer - 下一代智能面试官系统-Github](https://github.com/xgwangdl/AI-Interview)

**LangChain4J-XiaozhiAI 项目**
- [LangChain4J-XiaozhiAI 项目分析报告](https://blog.csdn.net/Joseit/article/details/147702788)
- [Github-LangChain4J-XiaozhiAI-Github](https://github.com/vasc-language/Java-EE/tree/main/LangChain4J-XiaozhiAI)
- https://github.com/vasc-language/Java-EE
- [B站小智医疗：Java大模型应用项目全流程实战](https://www.bilibili.com/video/BV1cpLTz1EVp?spm_id_from=333.788.videopod.episodes&vd_source=dbc23806939d448533f20d1daf00801f)

**其他**
- **LangChin4j**: https://docs.langchain4j.dev/get-started/; https://docs.langchain4j.dev/tutorials/spring-boot-integration
- **DeepSeek4j**: https://gitee.com/jason-lh/deepseek4j/tree/main
- 大语言模型排行榜: https://superclueai.com/
- 大模型平台：阿里百炼

## FAQ
### mac查看3306端口，验证端口是否正常
~~~shell
lsof -i :3306
netstat -an | grep 3306
nc -zv localhost 3306
~~~

### Docker镜像加速
增加Docker镜像源，避免国内拉取镜像失败
Mac Docker Desktop - Setting - Dock Engine 中增加’registry-mirrors‘
(or)配置文件：`/Applications/Docker.app/Contents/Resources/etc/daemon.json`
~~~json
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

（国内）拉取镜像
~~~shell
docker pull mongodb/mongodb-community-server:latest
docker pull docker.m.daocloud.io/mongodb/mongodb-community-server:latest

docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest
docker container ls

# 使用 mongosh 连接到 MongoDB 部署
docker exec -it mongodb bash
# mongosh --port 27017
~~~