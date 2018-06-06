package kr.ac.ks.board;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebBoardRepository extends CrudRepository<WebBoard, Long> {
    List<WebBoard> findAllByOrderByRegdateDesc();
}





