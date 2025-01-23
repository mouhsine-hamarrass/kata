package craft.team.kata.application.usecase;

import craft.team.kata.domain.model.Delivery;

public interface DeliverySaveUseCase {
    Delivery save(Delivery delivery);
}
