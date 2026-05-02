package com.SprignAI.firstProj.service;


import com.SprignAI.firstProj.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Service
public class chatServiceImp implements chatService {


    private ChatClient chatClient;

    public chatServiceImp(ChatClient.Builder builder){
        this.chatClient=builder.build();
    }
    @Override
    public String chat(String query) {

        //fluent api
        //call the llm for response


//        String content =chatClient
//                .prompt()
//                .user(prompt)
//                .system(" As an expert in cricket ")
//                .call()
//                .content();




        String prompt ="java collection framwork ";
        Prompt prompt1 = new Prompt(query);
        //sue placeholder also
        String queryStr = "As an  expert in coding and programming. Always write program in java. now reply for this question: {query}" ;

       var tutorial =chatClient
                .prompt(prompt1)
                .user(u->u.text(queryStr).param("query",query))
                .call()
                .content();
        return tutorial;
    }


    public  String chatTemplete (){
        // step 1
        PromptTemplate template = PromptTemplate.builder().template(" Tell about with {techName}? with an example of {Example}").build();
        // step 2 .. render
             String renderMessage =template.render(Map.of(
                     "techName","Spring",
                     "Example", "spring boot "
             ));

             // step 3 .. prompt
        Prompt prompt = new Prompt(renderMessage);


        return  chatClient.prompt(prompt).call().content();
    }
}
