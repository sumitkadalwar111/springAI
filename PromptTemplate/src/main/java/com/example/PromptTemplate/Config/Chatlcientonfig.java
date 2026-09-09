package com.example.PromptTemplate.Config;

import com.example.PromptTemplate.Advisor.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Chatlcientonfig {

    @Bean("chatClient")
    public ChatClient chatclient(ChatClient.Builder chatClient){
     var option=   OpenAiChatOptions.builder().model("gpt-5.4-mini").temperature(0.8).maxCompletionTokens(10);
        return chatClient

                .defaultOptions(option)
                .defaultAdvisors(new SimpleLoggerAdvisor() , new TokenUsageAuditAdvisor())

        .defaultSystem("""
                you are a professional   customer serice assistant which
                         help drafting email response to improve the productivity of the customer suport team""")
                .build();

    }
}
