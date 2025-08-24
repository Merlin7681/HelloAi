package ai.demo.langchain;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    /**
     * 测试openai(DeepSeek也是OpenAI接入方式)
     */
    @Test
    public void testOpenAiDemo() {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("XXXXXXXXXXXXXX")
                .modelName("deepseek-r1:1.5b")
                .build();

        String answer = model.chat("你好");
        System.out.println(answer);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;

    /**
     * 测试springboot
     * langchain4j-open-ai-spring-boot-starter
     * langchain4j.open-ai.chat-model.base-url=http://langchain4j.dev/demo/openai/v1
     * langchain4j.open-ai.chat-model.api-key=demo
     * NOTE: only model gpt-4o-mini is free for demo!
     */
    @Test
    public void testOpenAI4SpringBoot() {
        String answer = openAiChatModel.chat("我是谁？");
        System.out.println(answer);
    }
}