package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tbl_sample1")
@EqualsAndHashCode(of = "sno")
@ToString
public class Sample1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sample1")
	@SequenceGenerator(name = "seq_sample1", sequenceName = "SEQ_SAMPLE1", allocationSize=1, initialValue=1)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;

	private String col1;
	private String col2;

}
