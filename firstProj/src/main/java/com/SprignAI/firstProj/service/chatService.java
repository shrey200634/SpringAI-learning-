package com.SprignAI.firstProj.service;

import com.SprignAI.firstProj.entity.Tut;

import java.util.List;

public interface chatService {

    List<Tut> chat(String query);
}
