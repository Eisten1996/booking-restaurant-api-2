package pe.dipper.bookingrestaurantapi.services;

import pe.dipper.bookingrestaurantapi.exceptions.BookingException;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 21/11/2020 - 18:12
 */
public interface CancelReservationService {

    public String deleteReservation(String locator) throws BookingException;
}
