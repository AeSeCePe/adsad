package restobar.biz.platform.u202210697.attention.domain.services;

import restobar.biz.platform.u202210697.attention.domain.model.aggregates.Reservation;
import restobar.biz.platform.u202210697.attention.domain.model.commands.CreateReservationCommand;

public interface ReservationCommandService {
    Reservation handle(CreateReservationCommand command);
}
