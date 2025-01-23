package craft.team.kata.adapters.persistence;

import craft.team.kata.application.exception.KataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KataException.class)
    public ResponseEntity<ErrorMessage> handleKataException(KataException e) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                e.getMessage(),
                e.getHttpStatus()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getHttpStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                "An unexpected error occurred.",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
