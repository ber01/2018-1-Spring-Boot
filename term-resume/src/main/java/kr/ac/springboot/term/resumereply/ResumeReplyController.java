package kr.ac.springboot.term.resumereply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.resume.Resume;

@RestController
@RequestMapping("/replies/*")
public class ResumeReplyController {

	@Autowired
	private ResumeReplyRepository rep_repo;
	    
    @Transactional
    @PostMapping("/{rno}")
    public ResponseEntity<List<ResumeReply>> addReply(@PathVariable("rno") Long rno, @RequestBody ResumeReply reply) {

    	Resume resume = new Resume();
        resume.setRno(rno);
        reply.setResume(resume);
        rep_repo.save(reply);
        return new ResponseEntity<>(getListByResume(resume), HttpStatus.CREATED);
    }
    
    private List<ResumeReply> getListByResume(Resume resume) throws RuntimeException {
        return rep_repo.search(resume);
    }
    
    @Transactional
    @DeleteMapping("/{rno}/{pno}")
    public ResponseEntity<List<ResumeReply>> remove(
            @PathVariable("rno") Long rno,
            @PathVariable("pno") Long pno) {

        rep_repo.deleteById(pno);
        Resume resume = new Resume();
        resume.setRno(rno);
        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }
    
    @Transactional
    @PutMapping("/{rno}")
    public ResponseEntity<List<ResumeReply>> modify(@PathVariable("rno") Long rno, @RequestBody ResumeReply reply) {

        rep_repo.findById(reply.getPno()).ifPresent(origin -> {
            origin.setReplyText(reply.getReplyText());
            origin.setReplyer(reply.getReplyer());
            rep_repo.save(origin);
        });

        Resume resume = new Resume();
        resume.setRno(rno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }
    
    @GetMapping("/{rno}")
    public ResponseEntity<List<ResumeReply>> getReplies(@PathVariable("rno") Long rno) {

        Resume resume = new Resume();
        resume.setRno(rno);
        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }
}
