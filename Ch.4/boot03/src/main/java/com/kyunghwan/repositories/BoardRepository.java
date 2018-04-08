package com.kyunghwan.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kyunghwan.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
