package pe.dipper.bookingrestaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.CreateReservationRest;
import pe.dipper.bookingrestaurantapi.jsons.ReservationRest;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.ReservationService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 28/11/2020 - 18:45
 */

@RestController()
@CrossOrigin(value = "https://151.101.65.195:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws BookingException {
        return new BookingResponse<>("Success",
                String.valueOf(HttpStatus.OK), "OK",
                reservationService.createReservation(createReservationRest));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation" + "/{" + "reservationId"
            + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<ReservationRest> getReservationId(@PathVariable Long reservationId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.getReservation(reservationId));
    }

}
