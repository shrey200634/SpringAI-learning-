package com.SprignAI.firstProj.service;


import com.SprignAI.firstProj.entity.Tut;
import io.opencensus.resource.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class chatServiceImp implements chatService {
    private  ChatClient chatClient;
    @Value("classpath:/prompts/system-message.st")
    private String systemMessage;

    @Value("classpath:/prompts/user-message.st")
    private String userMessage;

    public chatServiceImp(@Qualifier("GoogleGenChatAI") ChatClient chatClient) {
        this.chatClient=chatClient;
    }


        @Override
    public  String chatTemplete(String q ){

        return  this.chatClient
                .prompt()
         //       .advisors(new SimpleLoggerAdvisor())
                .system("You are a helpful coding assistant. Explain concepts with examples and code.")   // ✅
                .user(u -> u.text("Explain the coding concept of: {concept}")
                        .param("concept", q))
                .call()
                .content();
        }

    }

