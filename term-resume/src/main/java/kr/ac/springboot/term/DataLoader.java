package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ExperienceRepository repo;
	
    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 11).forEach(i-> repo.save(new Experience("title" + i, "content" + i, "민경환")));
    
    }
}