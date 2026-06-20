package com.SprignAI.firstProj;

import com.SprignAI.firstProj.service.chatService;
import com.SprignAI.firstProj.service.chatServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstProjApplicationTests {

	@Autowired
	private chatService chatService;

	@Test
	void contextLoads() {
	}


	@Test
	void testTemplateRender(){
		System.out.println("Templete Renderer ");

		var output =this.chatService.chatTemplete();
		System.out.println(output);
	}

}
