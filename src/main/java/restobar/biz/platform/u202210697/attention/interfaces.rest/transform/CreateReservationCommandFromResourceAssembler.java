package restobar.biz.platform.u202210697.attention.interfaces.rest.transform;

import restobar.biz.platform.u202210697.attention.domain.model.commands.CreateReservationCommand;
import restobar.biz.platform.u202210697.attention.interfaces.rest.resources.CreateReservationResource;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource){
        LocalDate date;
        try {
            date = LocalDate.parse(resource.dateReservation());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format is yyyy-MM-dd.");
        }
        return new CreateReservationCommand(
                resource.nameRestaurant(),
                resource.clientId(),
                date,
                resource.countPerson()
        );
    }
}
