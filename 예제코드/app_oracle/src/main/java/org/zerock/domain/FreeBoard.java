package org.zerock.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="replies")
@Entity
@Table(name="tbl_freeboards")
@EqualsAndHashCode(of="bno")
public class FreeBoard {

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_board")
	  @SequenceGenerator(name = "seq_board", sequenceName = "SEQ_BOARD",  allocationSize=1, initialValue=1)
	  private Long bno;
	  private String title;
	  private String writer;
	  private String content;
	  
	  private String test1;

	  @CreationTimestamp
	  private Timestamp regdate;
	  @UpdateTimestamp
	  private Timestamp updatedate;
	  
	  @OneToMany(mappedBy="board" , 
			  cascade=CascadeType.ALL, 
			  fetch=FetchType.LAZY)
	  private List<FreeBoardReply> replies;
}
