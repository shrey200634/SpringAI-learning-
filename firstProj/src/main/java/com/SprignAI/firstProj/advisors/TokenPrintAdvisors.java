package com.SprignAI.firstProj.advisors;

import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;
import reactor.core.publisher.Flux;

import org.slf4j.Logger;

public class TokenPrintAdvisors implements CallAdvisor , StreamAdvisor {

    private Logger logger = LoggerFactory.getLogger(TokenPrintAdvisors.class);    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain)
        {
      this.logger.info("my token print advisor is called ");
      this.logger.info("Request" + chatClientRequest.prompt().getContents());

      ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
      this.logger.info("TokenAdvisor: Response  received form model ");
      this.logger.info("response:"+ chatClientResponse.chatResponse().getResult().getOutput().getText());
      this.logger.info("TotalTokenUsed :" +chatClientResponse.chatResponse().getMetadata().getUsage().getTotalTokens());
        return chatClientResponse;
    }

    @Override
    public Flux<ChatClientResponse> adviseStream(ChatClientRequest chatClientRequest, StreamAdvisorChain streamAdvisorChain) {
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
