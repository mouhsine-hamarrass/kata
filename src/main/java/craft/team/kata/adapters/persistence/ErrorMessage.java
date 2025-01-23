package craft.team.kata.adapters.persistence;


import java.time.LocalDateTime;


public record ErrorMessage(LocalDateTime timestamp,String message, int status) {
}
