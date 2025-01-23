package craft.team.kata.adapters.persistence;

import craft.team.kata.adapters.persistence.entity.DeliveryEntity;
import craft.team.kata.adapters.persistence.repository.DeliveryRepository;
import craft.team.kata.application.port.DeliveryWritePort;
import craft.team.kata.domain.model.Delivery;
import craft.team.kata.infrastructure.annotations.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class DeliveryWriteAdapter implements DeliveryWritePort {
    private final DeliveryPersistenceMapper deliveryPersistenceMapper;
    private final DeliveryRepository deliveryRepository;

    public Delivery save(Delivery delivery){
        DeliveryEntity entity = deliveryPersistenceMapper.toEntity(delivery);
        DeliveryEntity savedEntity = deliveryRepository.save(entity);
        return deliveryPersistenceMapper.toDomain(savedEntity);
    }
}
