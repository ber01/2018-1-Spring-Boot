package kr.ac.ks;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.ks.board.WebBoard;
import kr.ac.ks.board.WebBoardRepository;
import kr.ac.ks.boardreplay.WebBoardReply;
import kr.ac.ks.boardreplay.WebBoardReplyRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
    private WebBoardRepository repo;
	
	@Autowired
	private WebBoardReplyRepository replyRepo;

    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 100).forEach(i -> repo.save(new WebBoard("title"+i, "content"+i, "user"+(i%10))));
    	IntStream.range(1, 100).forEach(i -> replyRepo.save(new WebBoardReply("Text" + i, "Replayer" + i, repo.findById((long)i).orElse(null))));
    }
}
