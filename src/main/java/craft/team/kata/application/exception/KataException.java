package craft.team.kata.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class KataException extends RuntimeException{
    private final int httpStatus;

    public KataException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus.value();
    }
}
