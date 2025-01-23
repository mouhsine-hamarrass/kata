package craft.team.kata.domain.model;

import lombok.Getter;

@Getter
public enum DeliveryMode {
    DRIVE("Drive"),
    DELIVERY("Delivery"),
    DELIVERY_TODAY("Delivery Today"),
    DELIVERY_ASAP("Delivery ASAP");

    private final String label;

    DeliveryMode(String label) {
        this.label = label;
    }
}
