package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Experience {

	// Start Constructor
	// 기본 생성자
	public Experience() {
		
	}
	
	// 생성자(제목, 내용, 작성자)
	public Experience(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	// End Constructor

	// Start Attribute
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno; // 숫자
	
	private String title; // 과제 제목
	
	private String content; // 과제 내용
	
	private String writer; // 과제 작성자
	
	@CreationTimestamp
	private Timestamp regdate; // 작성시간
	
	@UpdateTimestamp
	private Timestamp updatedate; // 수정시간
	// End Attribute

	// Start getter/setter
	public Long getBno() {
		return bno;
	}

	public void setBno(Long bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	// Start toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Experience [bno=");
		builder.append(bno);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append(", updatedate=");
		builder.append(updatedate);
		builder.append("]");
		return builder.toString();
	}	
	// End toString
}
