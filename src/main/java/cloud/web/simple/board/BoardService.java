package cloud.web.simple.board;

import cloud.web.simple.board.domain.BoardDto;
import cloud.web.simple.board.domain.BoardFormDto;
import cloud.web.simple.entity.board.Board;
import cloud.web.simple.board.BoardRepository;
import cloud.web.simple.exception.NotFoundException;
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

    public BoardDto findById(int id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NotFoundException("id" + id + " 에 해당하는 게시물을 찾지 못하였습니다.")
        );

        return new BoardDto(board.getId(), board.getTitle(), board.getContent());
    }

    public int insertBoard(BoardFormDto boardFormDto){
        Board board = new Board();
        board.setTitle(boardFormDto.getTitle());
        board.setContent(boardFormDto.getContent());

        boardRepository.save(board);

        Board inputBoard = boardRepository.findTop1ByOrderByIdDesc().orElseThrow(
                () -> new NotFoundException("게시물이 없습니다.")
        );

        return inputBoard.getId();
    }

    public int updateBoard(BoardDto boardDto){
        Board board = boardRepository.findById(boardDto.getId()).orElseThrow(
                () -> new NotFoundException("id" + boardDto.getId() + " 에 해당하는 게시물을 찾지 못하였습니다.")
        );

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        return boardDto.getId();
    }

    public void deleteBoardById(int id){
        boardRepository.deleteById(id);
    }
}
