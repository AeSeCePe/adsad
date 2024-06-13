package restobar.biz.platform.u202210697.attention.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restobar.biz.platform.u202210697.attention.domain.services.ReservationCommandService;
import restobar.biz.platform.u202210697.attention.interfaces.rest.resources.CreateReservationResource;
import restobar.biz.platform.u202210697.attention.interfaces.rest.resources.ReservationResource;
import restobar.biz.platform.u202210697.attention.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import restobar.biz.platform.u202210697.attention.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import biz.hotel.platform.u202210846.shared.interfaces.rest.resources.MessageResource;

@RestController
@RequestMapping(value = "/api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservation", description = "Reservation Management Endpoint")
public class ReservationController{

    private ReservationCommandService reservationCommandService;
    public ReservationController(ReservationCommandService reservationCommandService) {
        this.reservationCommandService = reservationCommandService;
    }

    @PostMapping("/create-reservation")
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource){
        var createReservationCommand = new CreateReservationCommandFromResourceAssembler().toCommandFromResource(resource);
        var reservation = reservationCommandService.handle(createReservationCommand);
        if (reservation == null) {
            return ResponseEntity.badRequest().build();
        }
        var reservationResource = new ReservationResourceFromEntityAssembler().toResourceFromEntity(reservation);
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }
}

