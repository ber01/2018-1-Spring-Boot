package kr.ac.springboot.term.experience;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{

	// bno기준 내림차순 정렬
	List<Experience> findAllByOrderByBnoAsc();
}