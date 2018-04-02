package com.kyunghwan.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyunghwan.models.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>{

	
}
