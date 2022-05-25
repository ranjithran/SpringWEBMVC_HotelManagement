package com.cap.hotelMangement;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/hello")
	public String hello(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("spring", "mvc");
		model.addAttribute("message", "Baeldung");
		model.mergeAttributes(map);
		return "viewpage";
	}
}