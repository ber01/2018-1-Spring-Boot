package com.kyunghwan.boot02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyunghwan.models.Board;
import com.kyunghwan.repo.BoardRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot02ApplicationTests {

	@Autowired
	BoardRepo boardRepo;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("Hello");
		board.setContent("World");
		board.setWriter("user00");
		
		boardRepo.save(board);
	}
}