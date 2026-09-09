package com.example.PromptTemplate.Controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PromptStuffingController {



    private final ChatClient chatClient;

    public PromptStuffingController(ChatClient chatClient){
        this.chatClient=chatClient;
    }

@Value("classpath:/promptTemplate/SystemPromptTemplate.st")
Resource userPromptTemplate ;




    @GetMapping("/prompt-stuffing")
    public String emailResponse(@RequestParam("Message") String promptStuffing){
        return chatClient.prompt()
                .system(userPromptTemplate)
                .user(promptStuffing)
                .call()
                .content();
    }

}
