package craft.team.kata.application.port;

import craft.team.kata.domain.model.Delivery;

public interface DeliveryVerifyPort {
    boolean alreadyTaken(Delivery delivery);
}
