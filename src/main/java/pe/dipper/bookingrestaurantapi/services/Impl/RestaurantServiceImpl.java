package pe.dipper.bookingrestaurantapi.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pe.dipper.bookingrestaurantapi.entities.Restaurant;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.exceptions.NotFoundException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;
import pe.dipper.bookingrestaurantapi.repositories.RestaurantRepository;
import pe.dipper.bookingrestaurantapi.services.RestaurantService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 19/11/2020 - 23:48
 */
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Override
    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
        return MODEL_MAPPER.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
        return restaurantRepository
                .findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
    }
}
