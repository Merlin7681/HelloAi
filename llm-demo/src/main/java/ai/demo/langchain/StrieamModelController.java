package ai.demo.langchain;


import ai.demo.Conf;
import dev.langchain4j.chain.Chain;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.language.LanguageModel;
import dev.langchain4j.model.language.StreamingLanguageModel;
import dev.langchain4j.model.openai.OpenAiLanguageModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingLanguageModel;
import dev.langchain4j.model.output.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrieamModelController {
    @GetMapping("/langchain/streamlang")
    public Response<String> modelLang(@RequestParam(value = "message", defaultValue = "Hello") String message) {

        StreamingChatModel model = OpenAiStreamingChatModel.builder()
                .apiKey(Conf.OPENAI_API_KEY)
                .baseUrl(Conf.OPENAI_API_BASE_URL)
                .modelName(Conf.LOCAL_DEEPSEEK_MODEL)
                .build();

        //Response<String> result = model.generate(null);
        //System.out.println("end - result = " + result);
        return null;
    }

}
