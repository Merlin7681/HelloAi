package ai.demo.langchain;

//import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatLanguageModelController {
    @GetMapping("/langchain/chatmodel")
    public String modelChat(@RequestParam(value = "message", defaultValue = "How are you?") String message) {
        ChatModel model = OpenAiChatModel.builder()
                .apiKey("XXXXXXXXXXXXXX")
                .baseUrl("http://localhost:11434/v1")
                .modelName("deepseek-r1:1.5b")
                .build();

        ChatMessage chatMessage = SystemMessage.from("You are a helpful assistant.");
        UserMessage userMessage = UserMessage.from(
                TextContent.from("Hello!"),
                TextContent.from(message)
        );
        ConversationalChain chain = ConversationalChain.builder().chatModel(model).build();
        ChatRequest chatRequest = ChatRequest.builder()
                .messages(userMessage)
                //.temperature()
                //.responseFormat()
                .build();
        ChatResponse chatResponse = model.chat(chatRequest);
        String result;
        //result = chatMessage.toString();
        result = chain.execute(message);
        //result = model.chat(message);

        System.out.println("end - result = " + result);
        return result;
    }
}
