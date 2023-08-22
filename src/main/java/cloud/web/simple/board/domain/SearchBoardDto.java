package cloud.web.simple.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchBoardDto {
    private String title;
    private String content;
}
