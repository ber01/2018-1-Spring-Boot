package kr.ac.springboot.term.resume;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resume {
	
	// Start Constructor
	// 기본 생성자
	public Resume() {
    	
	}
	
	// 생성자(학번, 이름, 학교, 학과, 이메일, 소개글)
	public Resume(int sid, String name, String school, String department, String email, String introduction) {
		this.sid = sid;
		this.name = name;
		this.school = school;
		this.department = department;
		this.email = email;
		this.introduction = introduction;
	}
	// End Constructor

	// Start Attribute
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;

	private int sid; // 학번
    
    private String name; // 이름
    
    private String school; // 학교
    
    private String department; // 학과
    
    private String email; // 이메일
    
    private String introduction; // 소개글 
    // End Attribute

    // Start Getter/Setter
	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	// end Getter/Setter

	// Start toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resume [rno=");
		builder.append(rno);
		builder.append(", sid=");
		builder.append(sid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", school=");
		builder.append(school);
		builder.append(", department=");
		builder.append(department);
		builder.append(", email=");
		builder.append(email);
		builder.append(", introduction=");
		builder.append(introduction);
		builder.append("]");
		return builder.toString();
	}
	// End toString
	
}
