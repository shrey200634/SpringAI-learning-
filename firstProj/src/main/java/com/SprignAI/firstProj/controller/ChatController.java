package com.SprignAI.firstProj.controller;

import com.SprignAI.firstProj.entity.Tut;
import com.SprignAI.firstProj.service.chatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;

import java.util.List;

@RestController
@RequestMapping
public class ChatController
{

    private  ChatClient chatClient;
    private chatService chatService;


//    public ChatController(ChatClient.Builder chatClintBuilder){
//
//        this.chatClient=chatClintBuilder.build();
//    }

    public  ChatController (chatService chatService){
        this.chatService = chatService;

    }

//    private ChatClient openAiChatModel;
//    private ChatClient geminiChatClient;
//
//    public  ChatController(@Qualifier("openAIChatClint") ChatClient openAiChatModel ,
//                           @Qualifier("GoogleGenChatAI") ChatClient geminiChatClient){
//        this.geminiChatClient=geminiChatClient;
//        this.openAiChatModel=openAiChatModel;
//
//
//    }

//    public ChatController(OpenAiChatModel openAiChatModel, GoogleGenAiChatModel geminiChatModel) {
//
//        // 2. We assign the builder to those EXACT SAME variables here
//        this.groqChatClient = ChatClient.builder(openAiChatModel).build();
//        this.geminiChatClient = ChatClient.builder(geminiChatModel).build();
//    }

    @GetMapping("/chat")
    public ResponseEntity<List<Tut>> chat(@RequestParam(value = "q", required = true) String q) {
        return ResponseEntity.ok(chatService.chat(q));
    }
}