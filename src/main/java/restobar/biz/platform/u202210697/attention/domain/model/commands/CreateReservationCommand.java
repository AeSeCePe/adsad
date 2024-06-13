package restobar.biz.platform.u202210697.attention.domain.model.commands;

import java.time.LocalDate;

public record CreateReservationCommand(String nameRestaurant, Long clientId, LocalDate dateReservation, Long countPerson) {
}
