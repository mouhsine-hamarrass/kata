package craft.team.kata.adapters.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class DeliveryRequest {
    private String deliveryMode;
    private LocalDateTime slotStart;
    private LocalDateTime slotEnd;
}
