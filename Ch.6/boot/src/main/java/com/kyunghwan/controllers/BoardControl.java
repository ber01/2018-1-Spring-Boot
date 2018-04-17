package com.kyunghwan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunghwan.models.Board;
import com.kyunghwan.services.BoardService;

@RestController
public class BoardControl {

	@Autowired
	BoardService boardService;
	
	@PatchMapping("/patch")
	Board patchBoard() {
		return boardService.patchBoard(1L);
	}
	
	@GetMapping("/")
	List<Board> listGetAll(){
		return boardService.getFindAll();
	}
	
	@GetMapping("/title")
	List<Board> listGetTitle(){
		return boardService.getFindTitle("제목..177");
	}
	
	@GetMapping("/content")
	List<Board> listGetContent(){
		return boardService.getFindContent("내용..177");
	}
	
	@GetMapping("/writer")
	List<Board> listGetWriter(){
		return boardService.getFindWriterContaining("05");
	}
}
