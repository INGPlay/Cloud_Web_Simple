package cloud.web.simple.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private Date time;
    private String message;
    private String description;

    public ExceptionResponse(String message, String description) {
        this.time = new Date();

        this.message = message;
        this.description = description;
    }
}
