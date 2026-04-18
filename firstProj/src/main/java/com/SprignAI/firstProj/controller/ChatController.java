package com.SprignAI.firstProj.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;

@RestController
@RequestMapping
public class ChatController
{

    private final ChatClient groqChatClient;
    private final ChatClient geminiChatClient;

    public ChatController(OpenAiChatModel openAiChatModel, GoogleGenAiChatModel geminiChatModel) {

        // 2. We assign the builder to those EXACT SAME variables here
        this.groqChatClient = ChatClient.builder(openAiChatModel).build();
        this.geminiChatClient = ChatClient.builder(geminiChatModel).build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {

        var resultResponse=this.geminiChatClient
                .prompt(q).call().content();
        return ResponseEntity.ok(resultResponse);
    }
}