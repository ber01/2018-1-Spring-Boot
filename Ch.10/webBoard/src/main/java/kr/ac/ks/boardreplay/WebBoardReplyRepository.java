package kr.ac.ks.boardreplay;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.ac.ks.board.WebBoard;

public interface WebBoardReplyRepository extends CrudRepository<WebBoardReply, Long> {
	
	List<WebBoardReply>findAllByBoardOrderByUpdatedateDesc(WebBoard board);
}