package ai.demo.deepseek;

import io.github.pigmesh.ai.deepseek.core.DeepSeekClient;
import io.github.pigmesh.ai.deepseek.core.chat.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Flux;

@RestController
public class DeepSeekDemoControler {

    @Autowired
    private DeepSeekClient deepSeekClient;

    /**
     * 聊天
     * localhost:8080/chat?prompt=用Java输出hello
     * @param prompt
     * @return
     */
    @CrossOrigin("*")
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatCompletionResponse> chat(@RequestParam(name = "prompt") String prompt) {
        try {
            Flux<ChatCompletionResponse> flux = deepSeekClient.chatFluxCompletion(prompt);
            flux.subscribe(System.out::println);
            return flux;
        } catch (Exception e) {
            // 记录日志或者做其他处理
            throw new RuntimeException("Chat completion failed: " + e.getMessage(), e);
        }
    }

    @CrossOrigin("*")
    @GetMapping(value = "/chat2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String chat2(@RequestParam(name = "prompt") String prompt) {
        try {
            Flux<ChatCompletionResponse> flux = deepSeekClient.chatFluxCompletion(prompt);

            flux.subscribe(System.out::println);
            return "";
        } catch (Exception e) {
            // 记录日志或者做其他处理
            throw new RuntimeException("Chat completion failed: " + e.getMessage(), e);
        }
    }
}
