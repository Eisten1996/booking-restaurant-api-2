package pe.dipper.bookingrestaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.RestaurantService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 17:05
 */
@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId"
            + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }
}
