package cloud.web.simple.board.service;

import cloud.web.simple.board.domain.BoardDto;
import cloud.web.simple.entity.Board;
import cloud.web.simple.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;


    public List<BoardDto> findAllId(){
         return boardRepository.findAll().stream().map(
                b -> new BoardDto(b.getId(), b.getTitle(), b.getContent())
        ).collect(Collectors.toList());
    }

    public BoardDto findById(int index){
        Board board = boardRepository.findById(index).orElseThrow(
                () -> new RuntimeException()
        );

        return new BoardDto(board.getId(), board.getTitle(), board.getContent());
    }

    public int insertBoard(BoardDto boardDto){
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardRepository.save(board);

        Board inputBoard = boardRepository.findTop1ByOrderByIdDesc().orElseThrow(
                () -> new RuntimeException()
        );

        return inputBoard.getId();
    }

    public void deleteBoardById(int index){
        boardRepository.deleteById(index);
    }
}
