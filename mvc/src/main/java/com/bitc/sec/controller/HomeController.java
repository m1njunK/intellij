package com.bitc.sec.controller;

import com.bitc.sec.security.user.CustomUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home(@AuthenticationPrincipal CustomUser user, Model model) {
		model.addAttribute("data" , "SUM data");
		System.out.println(user); // 없으면 null
		if(user != null) {
			System.out.println(user.getMember());
		}
		return "home"
			;
	}

	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}
}
