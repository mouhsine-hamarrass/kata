package craft.team.kata.domain.model;

import java.time.LocalDateTime;


public record Delivery(DeliveryMode deliveryMode, LocalDateTime slotStart, LocalDateTime slotEnd) {

}
