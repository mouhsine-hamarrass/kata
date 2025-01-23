package craft.team.kata.adapters.rest;

import craft.team.kata.adapters.rest.dto.DeliveryRequest;
import craft.team.kata.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryAdapter deliveryAdapter;

    @PostMapping
    public ResponseEntity<Delivery> deliver(@RequestBody DeliveryRequest request) {
        return ResponseEntity.status(201).body(deliveryAdapter.saveDelivery(request));
    }
}
