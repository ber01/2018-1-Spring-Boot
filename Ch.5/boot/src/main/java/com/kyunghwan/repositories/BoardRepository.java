package com.kyunghwan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kyunghwan.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	// 몇 개의 값이 반환될 지 모르기 때문에 List 사용
	// title에 따라 값이 반환
	// 제네릭 타입 Board가 선언되어 있기 때문에 findBoardBy로 작성 하지 않는다.
	List<Board> findByTitle(final String title);
}