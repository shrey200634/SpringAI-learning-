package com.SprignAI.firstProj.service;


import com.SprignAI.firstProj.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class chatServiceImp implements chatService {


    private ChatClient chatClient;

    public chatServiceImp(ChatClient.Builder builder){
        this.chatClient=builder.build();
    }
    @Override
    public List<Tut> chat(String query) {

        //fluent api
        //call the llm for response


//        String content =chatClient
//                .prompt()
//                .user(prompt)
//                .system(" As an expert in cricket ")
//                .call()
//                .content();
        String prompt ="java collection framwork ";
        Prompt prompt1 = new Prompt(prompt);
        List<Tut> tutorial =chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {

                });





        return tutorial;
    }
}
