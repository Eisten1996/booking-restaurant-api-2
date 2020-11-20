package pe.dipper.bookingrestaurantapi.services;

import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 17:04
 */
@Service
public interface RestaurantService {

    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
}
