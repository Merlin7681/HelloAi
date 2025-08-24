package ai.demo.langchain;

import ai.demo.langchain.assistant.MemoryChatAssistant;
import ai.demo.langchain.assistant.SeparateChatAssistant;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    /**
     * 测试系统消息提示词
     * 在SeparateChatAssistant中使用@SystemMessage("你是我的好朋友，请用东北话回答问题。")
     */
    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(3,"今天几号");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer = memoryChatAssistant.chat("我是环环");
        System.out.println(answer);
    }

    @Test
    public void testUserMessage2() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我18了");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("你知道我是谁吗");
        System.out.println(answer3);
    }

    @Test
    public void testV () {
        String answer1 = separateChatAssistant.chat2 (10, "我是环环");
        System.out.println (answer1);
        String answer2 = separateChatAssistant.chat2 (10, "我是谁");
        System.out.println (answer2);
    }

    @Test
    public void testUserInfo () {
        String answer = separateChatAssistant.chat3 (1, "我是谁，我多大了", "翠花", 18);
        System.out.println (answer);
    }
}
