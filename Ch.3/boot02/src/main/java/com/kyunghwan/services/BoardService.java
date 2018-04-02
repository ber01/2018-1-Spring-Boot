package com.kyunghwan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyunghwan.models.Board;
import com.kyunghwan.repositories.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public void Writer() {
		Board b = new Board();
		b.setTitle("Hello");
		b.setContent("World!");
		b.setWriter("user00");
		boardRepository.save(b);
	}
	
	public String read() {
		return boardRepository.findById(1L).get().toString();
	}
}

