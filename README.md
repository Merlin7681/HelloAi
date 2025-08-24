# AI学习

## LLM-DEMO
主要内容：
- Ollama启动本地DeepSeek（或Qwen）模型，并通过deepseek4j和langchain4j两种方式进行交互；
- 学习langchain4j及其LLM的使用；

## XiaoZhiAgent
主要内容：
- 学习“尚硅谷-Java+大模型-硅谷小智”，并按照步骤进行项目开发学习；
- 调整ai.djl.huggingface.tokenizers版本，以支持Mac开发化境；
- 通过Ollama、Docker，并调整本地EmbeddingModel和存储，可以不用联网即可运行；

## 参考信息
### MCP
**模型上下文协议（Model Context Protocol，*MCP*）**，是由Anthropic推出的开源协议，旨在实现大语言模型与外部数据源和工具的集成，用来在大模型和数据源之间建立安全双向的连接 。

**提示词：**输入智能体的提示词（Prompt），用于规范和指导智能体完成任务的方式。你可以规定智能体的人设、回答口吻、工作流程、使用工具的时机和需要遵守的规范等。

**工具：**配置智能体处理需求时可以调用的工具，包括： **MCP Server**：添加 MCP Server 后，智能体在处理你的需求时可调用 MCP Server 提供的工具。你可以为一个智能体添加一个或多个 MCP Server。 

**工具举例**
- 文件系统：对文件进行增删改查。 
- 终端：在终端运行命令，并获取命令的运行状态和结果。 
- 联网搜索：搜索和用户任务相关的网页内容。 
- 预览：在生成可预览的前端结果后提供预览入口。
