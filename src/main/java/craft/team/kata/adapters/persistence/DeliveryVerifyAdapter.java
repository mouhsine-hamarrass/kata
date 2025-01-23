package craft.team.kata.adapters.persistence;

import craft.team.kata.adapters.persistence.repository.DeliveryRepository;
import craft.team.kata.application.port.DeliveryVerifyPort;
import craft.team.kata.domain.model.Delivery;
import craft.team.kata.infrastructure.annotations.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class DeliveryVerifyAdapter implements DeliveryVerifyPort {

    private final DeliveryRepository deliveryRepository;

    @Override
    public boolean alreadyTaken(Delivery delivery) {
        return deliveryRepository.existsOverlappingSlot(delivery.deliveryMode(), delivery.slotStart(), delivery.slotEnd());
    }
}
