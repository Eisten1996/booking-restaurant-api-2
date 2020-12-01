package pe.dipper.bookingrestaurantapi.controller;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.controllers.RestaurantController;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.RestaurantService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 28/11/2020 - 19:46
 */
public class RestaurantControllerTest {
    private static final Long RESTAURANT_ID = 1L;
    private static final String SUCCESS_STATUS = "Succes";
    private static final String SUCCESS_CODE = "200 OK";
    private static final String OK = "OK";

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
//        assertEquals(response.getData(), RESTAURANT_REST);
    }

}
