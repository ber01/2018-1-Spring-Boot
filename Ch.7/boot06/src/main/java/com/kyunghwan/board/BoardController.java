package com.kyunghwan.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards/")
public class BoardController {

	@GetMapping("/list")
	public void list() {
		System.out.println("called list()");
	}
}
