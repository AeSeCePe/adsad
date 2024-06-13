package restobar.biz.platform.u202210697.attention.domain.model.aggregates;

import biz.hotel.platform.u202210846.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import restobar.biz.platform.u202210697.attention.domain.model.entities.Client;

import java.time.LocalDate;

@Entity
@Getter
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

    @NotNull
    @Size(max = 50)
    private String nameRestaurant;

    @NotNull
    private Long clientId;

    @NotNull
    private LocalDate dateReservation;

    @NotNull
    private Long countPerson;

    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;

    public Reservation(){
        this.nameRestaurant = "";
        this.clientId = 0L;
        this.dateReservation = LocalDate.now();
        this.countPerson = 0L;
    }
    public Reservation(String nameRestaurant, Long clientId, LocalDate dateReservation, Long countPerson){
        this.nameRestaurant = nameRestaurant;
        this.clientId = clientId;
        this.dateReservation = dateReservation;
        this.countPerson = countPerson;
    }

}
