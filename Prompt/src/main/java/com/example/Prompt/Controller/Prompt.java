package com.example.Prompt.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Prompt {

    private final ChatClient chatClient;

    public Prompt(ChatClient chatClient){
         this.chatClient=chatClient;
    }




    @GetMapping("/chat")
    public String chat (@RequestParam("message") String message){
        return chatClient.prompt()
                //.user(message)
                .call()
                .content();
    }

}
