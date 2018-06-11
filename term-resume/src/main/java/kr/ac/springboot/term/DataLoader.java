package kr.ac.springboot.term;

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
    	ex_repo.save(new Experience("웹 프로그래밍", "Node JS를 이용한 웹 페이지 설계", "A-"));
    	ex_repo.save(new Experience("알고리즘", "다이나믹 프로그래밍", "A"));
    	ex_repo.save(new Experience("모바일 웹", "React.js를 이용한 웹 어플리케이션 개발", "A+"));
    }
}