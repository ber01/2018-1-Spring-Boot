package kr.ac.springboot.term.resumereply;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class ResumeReply {

	// 데이터베이스 연결
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Resume resume;
	
	// Start Constructor
	// 기본 생성자
	public ResumeReply() {

	}
	
	// 생성자(댓글 내용, 댓글 작성자, Resume 객체)
	public ResumeReply(String replyText, String replyer, Resume resume) {
		this.replyText = replyText;
		this.replyer = replyer;
		this.resume = resume;
	}	
	// End Constructor
	
	// Start Attribute
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long pno;
	
	private String replyText;
	
	private String replyer;
	
    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;
	// End Attribute

    // Start getter/setter
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Long getPno() {
		return pno;
	}

	public void setPno(Long pno) {
		this.pno = pno;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
    // End getter/setter

    // Start getter/setter
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResumeReply [resume=");
		builder.append(resume);
		builder.append(", pno=");
		builder.append(pno);
		builder.append(", replyText=");
		builder.append(replyText);
		builder.append(", replyer=");
		builder.append(replyer);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", updatedate=");
		builder.append(updatedate);
		builder.append("]");
		return builder.toString();
	}
    // End toString
}
