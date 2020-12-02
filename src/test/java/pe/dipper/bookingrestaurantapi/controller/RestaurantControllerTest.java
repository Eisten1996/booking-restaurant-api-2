package pe.dipper.bookingrestaurantapi.controller;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.controllers.RestaurantController;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;
import pe.dipper.bookingrestaurantapi.jsons.TurnRest;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 28/11/2020 - 19:46
 */
public class RestaurantControllerTest {
    private static final Long RESTAURANT_ID = 1L;
    private static final String NAME = "Burger";
    private static final String DESCRIPTION = "Todo tipo de Hamburguesa";
    private static final String ADDRESS = "Av Peru";
    private static final String IMAGE = "www.image.com";

    private static final String SUCCESS_STATUS = "Succes";
    private static final String SUCCESS_CODE = "200 OK";
    private static final String OK = "OK";

    private static final List<TurnRest> TURN_LIST = new ArrayList<>();
    private static final RestaurantRest RESTAURANT_REST = new RestaurantRest();
    private static final List<RestaurantRest> RESTAURANT_REST_LIST = new ArrayList<>();

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        RESTAURANT_REST.setName(NAME);
        RESTAURANT_REST.setDescription(DESCRIPTION);
        RESTAURANT_REST.setAddress(ADDRESS);
        RESTAURANT_REST.setId(RESTAURANT_ID);
        RESTAURANT_REST.setImage(IMAGE);
        RESTAURANT_REST.setTurns(TURN_LIST);

        Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
        Mockito.when(restaurantService.getRestaurants()).thenReturn(RESTAURANT_REST_LIST);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESTAURANT_REST);
    }

    @Test
    public void getRestaurantsTest() throws BookingException {
        final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurants();

        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESTAURANT_REST_LIST);

    }

}
