package com.kyunghwan.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kyunghwan.models.Board;

@Repository
public interface BoardRepo extends CrudRepository<Board, Long>{

}
