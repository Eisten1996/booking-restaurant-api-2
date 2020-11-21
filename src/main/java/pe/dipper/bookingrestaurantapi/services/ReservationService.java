package pe.dipper.bookingrestaurantapi.services;

import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.CreateReservationRest;
import pe.dipper.bookingrestaurantapi.jsons.ReservationRest;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 20/11/2020 - 22:17
 */
@Service
public interface ReservationService {

    ReservationRest getReservation(Long reservationId) throws BookingException;

    String createReservation(CreateReservationRest createReservationRest) throws BookingException;
}
