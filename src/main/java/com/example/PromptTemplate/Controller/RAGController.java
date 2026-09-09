package com.example.PromptTemplate.Controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rag")
public class RAGController {

    @Value("classpath:/promptTemplate/SystemPromptTemplate.st")
    Resource promptTemplate;


    private final ChatClient chatclient;
    private final VectorStore vectorStore;
    public RAGController (@Qualifier("chatMemoryChatCient") ChatClient chatclient, VectorStore vectorStore ){
        this.vectorStore= vectorStore;
        this.chatclient=chatclient;

    }

 @GetMapping("/random/rag")
    public ResponseEntity<String> randomChat(@RequestHeader("username") String username,@RequestParam("message") String message){
         
 }

}
