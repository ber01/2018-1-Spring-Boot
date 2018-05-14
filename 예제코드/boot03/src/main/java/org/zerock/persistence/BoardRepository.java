package org.zerock.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	public List<Board> findBoardByTitle(String title);

	public Collection<Board> findByWriter(String writer);

	// 작성자에 대한 like % 키워드 %
	public Collection<Board> findByWriterContaining(String writer);

	// OR조건의 처리
	public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);

	// title LIKE % ? % AND BNO > ?
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keywoard, Long num);

	// bno > ? ORDER BY bno DESC
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);

	// bno > ? ORDER BY bno DESC limit ?, ?
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);

	//
	//public List<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);

//	@Query("select board from Board board where board.title like %?1% and board.bno > 0 order by board.bno desc")
//	public List<Board> findByTitle(String title);
	
	@Query("SELECT b FROM Board b WHERE b.title like %?1% and b.bno > 0 ORDER BY b.bno desc")
	public List<Board> findByTitle(String title);


	@Query("select board.bno, board.title, board.writer, board.regdate "
	+ " from Board board where board.title like %?1% and board.bno > 0 order by board.bno desc")
	public List<Object[]> findByTitle2(String title);


	@Query("select board from Board board where board.bno > 0 order by board.bno desc")
	public List<Board> findBypage(Pageable pageable);

	@Query("SELECT b from Board b WHERE b.content like %:content%  and b.bno > 0 order by b.bno desc")
	public List<Board> findByContent(@Param("content") String content);
	
}
