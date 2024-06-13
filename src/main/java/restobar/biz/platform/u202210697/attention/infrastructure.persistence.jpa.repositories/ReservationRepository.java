package restobar.biz.platform.u202210697.attention.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restobar.biz.platform.u202210697.attention.domain.model.aggregates.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
