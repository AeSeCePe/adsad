package restobar.biz.platform.u202210697.attention.interfaces.rest.resources;

public record CreateReservationResource(String nameRestaurant, Long clientId, String dateReservation, Long countPerson) {
}
