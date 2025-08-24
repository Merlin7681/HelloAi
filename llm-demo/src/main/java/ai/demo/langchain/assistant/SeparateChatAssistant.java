package ai.demo.langchain.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import org.bson.types.ObjectId;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        //chatMemory = "chatMemory", // 聊天记忆（上下文），chatMemoryProvider已包含
        chatMemoryProvider = "chatMemoryProvider" // 聊天记录存储方式和 聊天记忆（上下文）
        , tools = "calculatorTools"
)
public interface SeparateChatAssistant {

    /**
     * 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息
     * @return
     */
    //@SystemMessage("你是我的好朋友，请用东北话回答问题。")//系统消息提示词
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage ("你是我的好朋友，请用粤语回答问题。{{message}}")
    String chat2 (@MemoryId int memoryId, @V("message") String userMessage);

    @SystemMessage (fromResource = "my-prompt-template3.txt")
    String chat3 (
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V ("username") String username,
            @V ("age") int age
    );

}