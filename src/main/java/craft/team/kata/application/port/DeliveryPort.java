package craft.team.kata.application.port;

import craft.team.kata.adapters.rest.dto.DeliveryRequest;
import craft.team.kata.domain.model.Delivery;

public interface DeliveryPort {
    Delivery saveDelivery(DeliveryRequest deliveryRequest);
}
