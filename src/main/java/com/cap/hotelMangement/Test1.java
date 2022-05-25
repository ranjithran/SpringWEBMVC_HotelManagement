package com.cap.hotelMangement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1 {

	@RequestMapping("add")
	public String add() {
		return "hello";
	}
}
