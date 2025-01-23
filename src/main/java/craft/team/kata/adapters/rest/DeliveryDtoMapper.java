package craft.team.kata.adapters.rest;

import craft.team.kata.adapters.rest.dto.DeliveryRequest;
import craft.team.kata.domain.model.DeliveryMode;
import craft.team.kata.domain.model.Delivery;
import craft.team.kata.infrastructure.annotations.Mapper;

@Mapper
public class DeliveryDtoMapper {

    public Delivery toDomain(DeliveryRequest request){
        return new Delivery(
                DeliveryMode.valueOf(request.getDeliveryMode()),
                request.getSlotStart(),
                request.getSlotEnd());
    }
}
