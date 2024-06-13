package restobar.biz.platform.u202210697.attention.application.internal.commandservices;

import org.springframework.stereotype.Service;
import restobar.biz.platform.u202210697.attention.domain.model.aggregates.Reservation;
import restobar.biz.platform.u202210697.attention.domain.model.commands.CreateReservationCommand;
import restobar.biz.platform.u202210697.attention.domain.services.ReservationCommandService;
import restobar.biz.platform.u202210697.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;

import java.util.List;
@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @Override
    public Reservation handle(CreateReservationCommand command) {
        List<Reservation> reservations = reservationRepository.findAll();
        boolean exists = reservations.stream()
                .anyMatch(r -> r.getNameRestaurant().equals(command.nameRestaurant())
                && r.getDateReservation().equals(command.dateReservation()));
        if (exists){
            return null;
        }
        Reservation reservation = new Reservation(command.nameRestaurant(), command.clientId(), command.dateReservation(), command.countPerson());
        reservationRepository.save(reservation);
        return reservation;
    }
}
