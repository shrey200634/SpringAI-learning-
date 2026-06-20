package com.SprignAI.firstProj.service;

import com.SprignAI.firstProj.entity.Tut;
import reactor.core.publisher.Flux;

import java.util.List;

public interface chatService {

  //  String chat(String query);

    String chatTemplete(String q);


    Flux<String> streamChat(String query);
}
