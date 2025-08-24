package ai.demo.langchain.assistant;

import dev.langchain4j.service.*;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProviderXiaozhi"
        , tools = "appointmentTools"
        , contentRetriever = "contentRetrieverXiaozhi" //配置向量存储
)
public interface XiaozhiAgent {

    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

    //@SystemMessage("你是我的好朋友，请用东北话回答问题。")//系统消息提示词
    //String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
