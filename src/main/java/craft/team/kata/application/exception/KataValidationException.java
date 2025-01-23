package craft.team.kata.application.exception;

import org.springframework.http.HttpStatus;

public class KataValidationException extends KataException {
    public KataValidationException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
