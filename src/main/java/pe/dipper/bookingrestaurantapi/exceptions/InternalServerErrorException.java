package pe.dipper.bookingrestaurantapi.exceptions;

import org.springframework.http.HttpStatus;
import pe.dipper.bookingrestaurantapi.ErrorDto;

import java.util.Arrays;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 22:02
 */
public class InternalServerErrorException extends BookingException {
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
