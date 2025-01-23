package craft.team.kata.application.port;

import craft.team.kata.domain.model.Delivery;

public interface DeliveryWritePort {
    Delivery save(Delivery delivery);
}
