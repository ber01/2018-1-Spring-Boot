package kr.ac.springboot.term.resumereply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResumeReply {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long pno;
}
