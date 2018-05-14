package org.zerock;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void inspect() {

		Class<?> clz = boardRepo.getClass();

		System.out.println(clz.getName());

		Class<?>[] interfaces = clz.getInterfaces();

		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

		Class<?> superClasses = clz.getSuperclass();

		System.out.println(superClasses.getName());
	}

	@Test
	public void testInsert() {

		Board board = new Board();
		board.setTitle("게시물의 제목");
		board.setContent("게시물 내용 넣기....");
		board.setWriter("user00");

		boardRepo.save(board);

	}

	@Test
	public void testRead() {

		Board board = boardRepo.findOne(1L);

		System.out.println(board);

	}

	@Test
	public void testUpdate() {

		System.out.println("Read First.........................");
		Board board = boardRepo.findOne(1L);

		System.out.println("Update Title.......................");
		board.setTitle("수정된 제목입니다");

		System.out.println("Call Save( ).......................");
		boardRepo.save(board);

	}

}
