package kr.ac.ks;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.ks.board.WebBoard;
import kr.ac.ks.board.WebBoardRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private WebBoardRepository repo;

    @Autowired
    public DataLoader(WebBoardRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(0, 100).forEach(i -> repo.save(new WebBoard("title"+i, "content"+i, "user"+(i%10))));
    }
}
