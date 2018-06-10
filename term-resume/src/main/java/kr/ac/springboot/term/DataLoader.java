package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository re_repo;
	
	@Autowired
	private ExperienceRepository ex_repo;
	
    @Override
    public void run(ApplicationArguments args) {
    	re_repo.save(new Resume(2014658045, "민경환", "경성대학교", "소프트웨어학과", "ksyj8256@gmail.com", "2018_WEB_Programming_Term_Projcet"));
    	IntStream.range(1, 11).forEach(i-> ex_repo.save(new Experience("title" + i, "content" + i, "민경환")));
    }
}