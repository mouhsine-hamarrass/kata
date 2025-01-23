package craft.team.kata.adapters.persistence.repository;

import craft.team.kata.adapters.persistence.entity.DeliveryEntity;
import craft.team.kata.domain.model.DeliveryMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

    @Query("SELECT COUNT(d) > 0 " +
            "FROM DeliveryEntity d " +
            "WHERE d.deliveryMode = :deliveryMode " +
            "AND (:slotStart < d.slotEnd AND :slotEnd > d.slotStart)")
    boolean existsOverlappingSlot(@Param("deliveryMode") DeliveryMode deliveryMode,
                                  @Param("slotStart") LocalDateTime slotStart,
                                  @Param("slotEnd") LocalDateTime slotEnd);
}
