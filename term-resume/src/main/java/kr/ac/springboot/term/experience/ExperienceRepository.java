package kr.ac.springboot.term.experience;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{

	// 제작시기준 오름차순 정렬
	List<Experience> findAllByOrderByRegdateAsc();
}