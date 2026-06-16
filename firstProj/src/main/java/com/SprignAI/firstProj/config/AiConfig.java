package com.SprignAI.firstProj.config;

import com.SprignAI.firstProj.advisors.TokenPrintAdvisors;
import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {


//    @Bean("openAIChatClint")
//    public ChatClient openAiChatModel(OpenAiChatModel openAiChatModel){
//      return ChatClient.builder(openAiChatModel).build();
//
//    }
    @Bean("GoogleGenChatAI")
    public ChatClient googleGenAiChatModel(GoogleGenAiChatModel googleGenAiChatModel){
        return ChatClient.builder(googleGenAiChatModel)
                .defaultAdvisors(new TokenPrintAdvisors() ).build();

    }
}
