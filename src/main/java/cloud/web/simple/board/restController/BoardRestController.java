package cloud.web.simple.board.restController;

import cloud.web.simple.board.domain.BoardDto;
import cloud.web.simple.board.domain.SearchBoardDto;
import cloud.web.simple.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<BoardDto>> findAllBoard(){

        return new ResponseEntity<>(boardService.findAllId(), HttpStatus.OK);
    }

    @GetMapping("/board/{index}")
    public ResponseEntity<BoardDto> findBoard(@PathVariable Integer index){

        return new ResponseEntity<>(boardService.findById(index), HttpStatus.OK);
    }

    @PostMapping("/board")
    public Integer insertBoard(@RequestBody BoardDto boardDto){

        return boardService.insertBoard(boardDto);
    }

    @DeleteMapping("/board/{index}")
    public Integer deleteBoard(@PathVariable Integer index){

        boardService.deleteBoardById(index);
        return index;
    }
}
