 package kr.ac.ks.boardreplay;

import kr.ac.ks.board.WebBoard;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_webboardreplies")
public class WebBoardReply {
	
    public WebBoardReply() {

	}

	public WebBoardReply(String replyText, String replyer, WebBoard board) {
		this.replyText = replyText;
		this.replyer = replyer;
		this.board = board;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;

    private String replyText;

    private String replyer;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private WebBoard board;

	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
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

	public WebBoard getBoard() {
		return board;
	}

	public void setBoard(WebBoard board) {
		this.board = board;
	}
}
