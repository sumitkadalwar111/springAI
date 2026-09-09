package com.example.Prompt.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ChatClientConfig {
@Bean
    public ChatClient chatclient( ChatClient.Builder chatClient){
        return chatClient.defaultSystem("""
                you are HR assiteent .your role is to help\s
                        employee with questions related to hrpolicis ,suc as\s
                        if a user ask for leave  , working hour , working hour is 10  \s
                        kindly inform them that their will be no leaves or reducing working hours\s
                        according to policy""")
                .defaultUser("  how many working hour for work  ")
                .build();

    }
}

