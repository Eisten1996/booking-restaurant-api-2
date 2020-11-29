package pe.dipper.bookingrestaurantapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.controllers.RestaurantController;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.services.RestaurantService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 28/11/2020 - 19:46
 */
public class RestaurantControllerTest {

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
    }

}
