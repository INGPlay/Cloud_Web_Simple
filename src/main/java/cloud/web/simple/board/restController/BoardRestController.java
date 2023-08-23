package cloud.web.simple.board.restController;

import cloud.web.simple.board.domain.BoardDto;
import cloud.web.simple.board.domain.BoardFormDto;
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

    @GetMapping("/board/{id}")
    public ResponseEntity<BoardDto> findBoard(@PathVariable Integer id){

        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/board")
    public Integer insertBoard(@RequestBody BoardFormDto boardDto){

        return boardService.insertBoard(boardDto);
    }

    @PutMapping("/board")
    public Integer updateBoard(@RequestBody BoardDto boardDto){

        return boardService.updateBoard(boardDto);
    }

    @DeleteMapping("/board/{id}")
    public Integer deleteBoard(@PathVariable Integer id){

        boardService.deleteBoardById(id);
        return id;
    }
}
