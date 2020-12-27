package pe.dipper.bookingrestaurantapi.services;

import pe.dipper.bookingrestaurantapi.exceptions.BookingException;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 25/12/2020 - 22:20
 */
public interface EmailService {

    public String processSendEmail(final String receiver, String templateCode, String currentName)
            throws BookingException;
}
