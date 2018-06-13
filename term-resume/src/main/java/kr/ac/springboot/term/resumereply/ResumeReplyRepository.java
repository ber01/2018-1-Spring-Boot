package kr.ac.springboot.term.resumereply;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.resume.Resume;

public interface ResumeReplyRepository extends CrudRepository<ResumeReply, Long>{
	
	@Query("SELECT r FROM ResumeReply r WHERE r.resume = 1 AND r.pno > 0 ORDER BY r.pno ASC")
	List<ResumeReply> search(Resume resume);
}
