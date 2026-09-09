package com.example.PromptTemplate.Controller;


import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PromptClassController {



    private final ChatClient chatClient;

    public PromptClassController(@Qualifier("chatClient") ChatClient chatClient){
        this.chatClient=chatClient;
    }

@Value("classpath:/promptTemplate/userPromptTemplate.st")
Resource userPromptTemplate ;




    @GetMapping("/email")
    public String emailResponse(@RequestParam("CustomerName") String CustomerName,
                                @RequestParam("CustomerMessage") String CustomerMessage){
        return chatClient.prompt()
                .system("""
                         you are a professional   customer serice assistant which
                         help drafting email response to improve the productivity of the customer suport team""")
                .user(promptUserSpec -> promptUserSpec.text(userPromptTemplate)
                        .param("CustomerName",CustomerName)
                        .param("CustomerMessage",CustomerMessage))
                .call()
                .content();
    }

}
