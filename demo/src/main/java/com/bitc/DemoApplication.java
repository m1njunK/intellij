package com.bitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("data","SAMPLE DATA");
		return "home";
	}

	@GetMapping("/user/login")
	public String login(){
		return "user/login";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
