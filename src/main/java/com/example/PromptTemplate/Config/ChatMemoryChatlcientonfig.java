package com.example.PromptTemplate.Config;

import com.example.PromptTemplate.Advisor.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatMemoryChatlcientonfig {

    @Bean("chatMemoryChatCient")
    public ChatClient chatclient(ChatClient.Builder chatClient, ChatMemory chatMemory){
        Advisor logger = new SimpleLoggerAdvisor();
        Advisor memoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

return chatClient.
        defaultAdvisors(List.of(logger,memoryAdvisor))
        .build();
    }
}
