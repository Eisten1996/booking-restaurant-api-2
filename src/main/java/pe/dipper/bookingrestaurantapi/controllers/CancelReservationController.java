package pe.dipper.bookingrestaurantapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.CancelReservationService;
import pe.dipper.bookingrestaurantapi.services.Impl.CancelReservationServiceImpl;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 28/11/2020 - 19:18
 */

@RestController()
@CrossOrigin(value = "https://booking-restaurant-app.web.app:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationController.class);

    @Autowired
    CancelReservationService cancelReservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException {
        return new BookingResponse<>("Success",
                String.valueOf(HttpStatus.OK), "OK",
                cancelReservationService.deleteReservation(locator));
    }
}
