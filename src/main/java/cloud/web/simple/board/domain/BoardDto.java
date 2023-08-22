package cloud.web.simple.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDto {
    private int id;
    private String title;
    private String content;
}
