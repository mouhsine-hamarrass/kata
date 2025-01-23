package craft.team.kata.adapters.rest;

import craft.team.kata.application.port.DeliveryPort;
import craft.team.kata.adapters.rest.dto.DeliveryRequest;
import craft.team.kata.application.usecase.DeliverySaveUseCase;
import craft.team.kata.domain.model.Delivery;
import craft.team.kata.infrastructure.annotations.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class DeliveryAdapter implements DeliveryPort {

    private final DeliveryDtoMapper deliveryDtoMapper;
    private final DeliverySaveUseCase deliverySaveUseCase;
    @Override
    public Delivery saveDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryDtoMapper.toDomain(deliveryRequest);
        return deliverySaveUseCase.save(delivery);
    }
}
