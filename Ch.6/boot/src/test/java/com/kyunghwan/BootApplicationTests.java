package com.kyunghwan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyunghwan.models.Board;
import com.kyunghwan.repositories.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
	
	// 인터페이스 객체를 Spring이 자동으로 생성
	@Autowired 
	private BoardRepository boardRepository;
	
	// 쿼리문 작성
	@Test
	public void testInsert200() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("제목.." + i);
			board.setContent("내용.." + i);
			board.setWriter("user0" + (i%10));
			boardRepository.save(board);
		}
	}
	
	@Test
	public void contextLoads() {
	}
}
