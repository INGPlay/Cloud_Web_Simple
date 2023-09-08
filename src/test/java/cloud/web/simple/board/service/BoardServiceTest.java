package cloud.web.simple.board.service;

import cloud.web.simple.board.BoardService;
import cloud.web.simple.board.domain.BoardFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @Transactional
    void insertBoard() {
        BoardFormDto boardFormDto = new BoardFormDto("테스트제목", "테스트내용");
        boardService.insertBoard(boardFormDto);
    }
}