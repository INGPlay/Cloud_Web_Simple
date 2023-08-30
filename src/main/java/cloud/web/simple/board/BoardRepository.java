package cloud.web.simple.board;

import cloud.web.simple.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    public Optional<Board> findTop1ByOrderByIdDesc();
}
