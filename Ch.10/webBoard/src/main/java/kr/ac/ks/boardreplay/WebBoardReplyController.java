package kr.ac.ks.boardreplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.ac.ks.board.WebBoard;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/replies/*")
public class WebBoardReplyController {
	
	@Autowired
	private WebBoardReplyRepository reply;

    @GetMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> getReplies(@PathVariable("bno") Long bno) {
    	WebBoard board = new WebBoard();
    	board.setBno(bno);
        return new ResponseEntity<>(reply.findAllByBoardOrderByUpdatedateDesc(board), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> addReply(@PathVariable("bno") Long bno, @RequestBody WebBoardReply reply) {
        // save Reply
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{bno}/{rno}")
    public ResponseEntity<List<WebBoardReply>> remove(@PathVariable("bno") Long bno, @PathVariable("rno") Long rno) {
        // delete Reply
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> modify(@PathVariable("bno") Long bno, @RequestBody WebBoardReply reply) {
        // edit Reply
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    private List<WebBoardReply> getListByBoard(WebBoard board) throws RuntimeException {}
}
