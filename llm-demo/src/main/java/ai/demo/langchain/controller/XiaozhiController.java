package ai.demo.langchain.controller;

import ai.demo.langchain.assistant.XiaozhiAgent;
import ai.demo.langchain.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }

    @Operation(summary = "对话")
    @GetMapping("/chat2")
    public String chat(@RequestParam Long memoryId, @RequestParam String message) {
        return xiaozhiAgent.chat(memoryId, message);
    }
}
