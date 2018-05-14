package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long> {

	@Query("select r FROM FreeBoardReply r WHERE r.board = ?1 ORDER BY r.rno ASC")
	public List<FreeBoardReply> getReply(FreeBoard board);
	
}
