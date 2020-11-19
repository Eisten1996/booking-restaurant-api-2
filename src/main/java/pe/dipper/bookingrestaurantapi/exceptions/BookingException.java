package pe.dipper.bookingrestaurantapi.exceptions;

import pe.dipper.bookingrestaurantapi.dtos.ErrorDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 21:44
 */
public class BookingException extends Exception {
    private final String code;
    private final int responseCode;
    private final List<ErrorDto> errorDtoList = new ArrayList<>();

    public BookingException(String code, int responseCode, String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public BookingException(String code, int responseCode, String message, List<ErrorDto> errorDtoList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorDtoList.addAll(errorDtoList);
    }

    public String getCode() {
        return code;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public List<ErrorDto> getErrorDtoList() {
        return errorDtoList;
    }
}
