package ai.demo.langchain;

import ai.demo.langchain.assistant.Assistant;
import ai.demo.langchain.assistant.Assistant2;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }

    @Autowired
    Assistant2 assistant2;

    @Test
    public void testAssistant() {
        String answer = assistant2.chat("你是谁");
        System.out.println(answer);
    }
}
