package restobar.biz.platform.u202210697.attention.interfaces.rest.transform;

import restobar.biz.platform.u202210697.attention.domain.model.aggregates.Reservation;
import restobar.biz.platform.u202210697.attention.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation reservation){
        return new ReservationResource(
                reservation.getNameRestaurant(),
                reservation.getClientId(),
                reservation.getDateReservation().toString(),
                reservation.getCountPerson()
        );
    }
}
