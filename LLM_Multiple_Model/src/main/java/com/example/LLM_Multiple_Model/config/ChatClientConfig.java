package com.example.LLM_Multiple_Model.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {


    @Bean
    @Qualifier("openAiChatClient")
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel){
        return ChatClient.create(openAiChatModel);
    }
    @Bean
    @Qualifier("OllamaChatClient")
    public ChatClient OllamaChatClient(OllamaChatModel ollamaChatModel){
        ChatClient.Builder chatClientBuilder= ChatClient.builder(ollamaChatModel);
        return chatClientBuilder.build();
    }


}
