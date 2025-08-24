package ai.demo.langchain.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

//@AiService(wiringMode = EXPLICIT, chatModel = "openAiChatModel")
//@AiService
@AiService(wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider", // 聊天记录存储方式和 聊天记忆（上下文）
        chatMemory = "chatMemory")
public interface Assistant2 {
    String chat(String userMessage);
}
