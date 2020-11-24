package pe.dipper.bookingrestaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    public BookingResponse<RestaurantRest> getRestaurantId(Long restaurantId) throws BookingException {
        return new BookingResponse<>(
                "Success",
                String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId)
        );
    }
}
