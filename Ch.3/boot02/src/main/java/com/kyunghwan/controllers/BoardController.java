package com.kyunghwan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunghwan.services.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	String hello() {
		boardService.read();
		return "Hello World!";
	}
	
	@PostMapping("/board")
	String world() {
		boardService.read();
		return "Done";
	}
}
