package com.SprignAI.firstProj.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class chatServiceImp implements chatService {


    private ChatClient chatClient;

    public chatServiceImp(ChatClient.Builder builder){
        this.chatClient=builder.build();
    }
    @Override
    public String chat(String query) {
        String prompt ="Tell me about Virat kholi ";

        //fluent api
        //call the llm for response

        return "";
    }
}
