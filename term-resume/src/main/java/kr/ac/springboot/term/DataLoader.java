package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;
import kr.ac.springboot.term.resumereply.ResumeReply;
import kr.ac.springboot.term.resumereply.ResumeReplyRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository re_repo;
	
	@Autowired
	private ExperienceRepository ex_repo;
	
	@Autowired
	private ResumeReplyRepository rep_repo;
	
	Resume resume = new Resume(2014658045, "민경환", "경성대학교", "소프트웨어학과", "ksyj8256@gmail.com", "2018_WEB_Programming_Term_Projcet");
	
    @Override
    public void run(ApplicationArguments args) {
    	re_repo.save(resume);
    	ex_repo.save(new Experience("웹 프로그래밍", "Node JS를 이용한 웹 페이지 설계", "A-", resume));
    	ex_repo.save(new Experience("알고리즘", "다이나믹 프로그래밍", "A", resume));
    	ex_repo.save(new Experience("모바일 웹", "React.js를 이용한 웹 페이지 개발", "A+", resume));
    	ex_repo.save(new Experience("파이썬", "크롤링 애플리케이션 만들기", "A+", resume));
    	ex_repo.save(new Experience("오픈소프트웨어", "리눅스 구축관리 실무", "A", resume));
    	ex_repo.save(new Experience("도커", "Docker를 이용한 애플리케이션 배포", "A+", resume));
    	rep_repo.save(new ResumeReply("몇 살?", "홍길동", resume));
    	rep_repo.save(new ResumeReply("학년이?", "이순신", resume));
    }
}