package kr.ac.springboot.term.resume;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume, Long> {

	List<Resume> findByRno(Long rno);
}
