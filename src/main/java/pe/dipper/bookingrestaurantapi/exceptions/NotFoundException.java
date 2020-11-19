package pe.dipper.bookingrestaurantapi.exceptions;

import org.springframework.http.HttpStatus;
import pe.dipper.bookingrestaurantapi.ErrorDto;

import java.util.Arrays;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 21:58
 */
public class NotFoundException extends BookingException {
    public NotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}
