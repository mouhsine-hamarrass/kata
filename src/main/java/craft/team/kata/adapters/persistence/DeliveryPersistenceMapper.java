package craft.team.kata.adapters.persistence;

import craft.team.kata.adapters.persistence.entity.DeliveryEntity;
import craft.team.kata.domain.model.Delivery;
import craft.team.kata.infrastructure.annotations.Mapper;

@Mapper
public class DeliveryPersistenceMapper {
    public DeliveryEntity toEntity(Delivery delivery){
        return DeliveryEntity.builder()
                .deliveryMode(delivery.deliveryMode())
                .slotStart(delivery.slotStart())
                .slotEnd(delivery.slotEnd())
                .build();
    }

    public Delivery toDomain(DeliveryEntity savedEntity) {
        return new Delivery(savedEntity.getDeliveryMode(), savedEntity.getSlotStart(), savedEntity.getSlotEnd());
    }
}
