package cn.edu.xynu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
	
	@GetMapping("/other/1")
	public String mes_1(Model model){
		return "other/1";
	}	
	@GetMapping("/other/2")
	public String mes_2(Model model){
		return "other/2";
	}
	@GetMapping("/other/3")
	public String mes_3(Model model){
		return "other/3";
	}
	@GetMapping("/other/4")
	public String mes_4(Model model){
		return "other/4";
	}
	@GetMapping("/other/5")
	public String mes_5(Model model){
		return "other/5";
	}
}
