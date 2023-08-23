package cloud.web.simple.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardFormDto {
    private String title;
    private String content;
}
