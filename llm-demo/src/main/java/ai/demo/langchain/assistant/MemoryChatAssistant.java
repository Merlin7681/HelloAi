package ai.demo.langchain.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * MemoryChatAssistant
 * chubu de Agent(zhinengti).
 */
@AiService(wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider", // 聊天记录存储方式和 聊天记忆（上下文）
        chatMemory = "chatMemory")
public interface MemoryChatAssistant {

    @SystemMessage(fromResource = "my-prompt-template.txt")
    // @SystemMessage("你是我的好朋友，请用东北话回答问题。")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
    //String chat(String userMessage);

    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{it}}") //{{it}}表示这里唯一的参数的占位符
    String chat(String message);
}
