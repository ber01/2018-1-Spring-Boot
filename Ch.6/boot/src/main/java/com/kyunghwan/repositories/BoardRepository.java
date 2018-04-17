package com.kyunghwan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kyunghwan.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	List<Board> findAll();
	
	// title 177 가져오기 / Select * From Board while title
	List<Board> findByTitle(String title);	
	
	// content 177 가져오기 / Select * From Board while content
	List<Board> findByContent(String content);

	// %LIKE%
	// 해당 writer에 속한 모든 내용을 전부 가지고 옴
	List<Board> findByWriterContaining(String writer);	
}