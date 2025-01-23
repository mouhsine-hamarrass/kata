package craft.team.kata.application.service;

import craft.team.kata.application.exception.KataValidationException;
import craft.team.kata.application.port.DeliveryVerifyPort;
import craft.team.kata.application.port.DeliveryWritePort;
import craft.team.kata.application.usecase.DeliverySaveUseCase;
import craft.team.kata.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DeliverySaveService implements DeliverySaveUseCase {
    private final DeliveryWritePort deliveryWritePort;
    private final DeliveryVerifyPort deliveryVerifyPort;

    public Delivery save(Delivery delivery) {
        if (delivery.slotStart().isAfter(delivery.slotEnd())){
            throw new KataValidationException("The start period should not be after the end period.");
        }
        boolean alreadyTaken = deliveryVerifyPort.alreadyTaken(delivery);
        if (alreadyTaken) throw new KataValidationException(
                String.format("The delivery mode [%s] in the period [%s, %s] is already taken.",
                        delivery.deliveryMode(),
                        delivery.slotStart().format(DateTimeFormatter.ISO_DATE_TIME),
                        delivery.slotEnd().format(DateTimeFormatter.ISO_DATE_TIME))
        );

        return deliveryWritePort.save(delivery);
    }
}
