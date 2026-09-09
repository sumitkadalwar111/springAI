package com.example.PromptTemplate.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.http.ResponseEntity; // Correct import for ResponseEntity
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatClietMemory {

    private final ChatClient chatClient;

    public ChatClietMemory(@Qualifier("chatMemoryChatCient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat-memory")
    public ResponseEntity<String> chatMemory(
            @RequestHeader ("username") String username,
            @RequestParam("message") String message
       ) {

        String response = chatClient.prompt()
                .user(message)
                // Ensure your advisor uses the conversation ID for tracking state
                . advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,username))
                .call()
                .content();

        return ResponseEntity.ok(response);
    }
}