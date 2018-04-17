package com.kyunghwan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyunghwan.repositories.BoardRepository;
import com.kyunghwan.models.Board;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public Board patchBoard(Long id) {		
		// 1. findByID
		Optional<Board> board = boardRepository.findById(id);
		
		// 2. Patch
		// 반환 값이 존재
		if (board.isPresent()) {
			// Wrapper 해제
			Board patchBoard = board.get();
			patchBoard.setTitle("(patch)" + patchBoard.getTitle());
			
			// 3. 저장
			// patchBoard의 식별키가 살아있으면 데이터를 추가하지 않고 그 내용을 수정한다.
			// update를 할 때 식별키를 수정하면 insert가 되버린다.
			boardRepository.save(patchBoard);
		}
		
		// 반환 값이 존재하지 않으면 null 반환
		return null;
	}
	
	public List<Board> getFindAll(){
		return boardRepository.findAll();
	}
	
	public List<Board> getFindTitle(String title){
		return boardRepository.findByTitle(title);
	}
	
	public List<Board> getFindContent(String content){
		return boardRepository.findByContent(content);
	}
	
	public List<Board> getFindWriterContaining(String writer){
		return boardRepository.findByWriterContaining(writer);
	}
}