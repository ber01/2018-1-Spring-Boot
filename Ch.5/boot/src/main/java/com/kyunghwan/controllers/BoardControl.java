package com.kyunghwan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunghwan.models.Board;
import com.kyunghwan.repositories.BoardRepository;

@RestController
public class BoardControl {

	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping
	public List<Board> getListBoardByTitle(){
		return boardRepository.findByTitle("제목..177");
	}
}
