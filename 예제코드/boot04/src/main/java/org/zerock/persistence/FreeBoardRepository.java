package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

	
	public List<FreeBoard> findByBnoGreaterThan(Long bno, Pageable page);

	@Query("SELECT b.bno, b.title, count(r) " +
	" FROM FreeBoard b LEFT OUTER JOIN b.replies r " + 
	" WHERE b.bno > 0 group by b ")
	public List<Object[]> getPage(Pageable page);
	
	
	@Query("SELECT b.bno, b.title, count(r) FROM FreeBoard b LEFT OUTER JOIN FreeBoardReply r ON b.bno = r.board WHERE b.bno> 0 group by b ")
	public List<Object[]> getPage52(Pageable page);
	
}
