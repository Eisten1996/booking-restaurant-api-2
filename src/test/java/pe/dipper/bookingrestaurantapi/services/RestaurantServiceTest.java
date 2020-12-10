package pe.dipper.bookingrestaurantapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.entities.Board;
import pe.dipper.bookingrestaurantapi.entities.Reservation;
import pe.dipper.bookingrestaurantapi.entities.Restaurant;
import pe.dipper.bookingrestaurantapi.entities.Turn;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.RestaurantRest;
import pe.dipper.bookingrestaurantapi.repositories.RestaurantRepository;
import pe.dipper.bookingrestaurantapi.services.Impl.RestaurantServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 02/12/2020 - 14:53
 */
public class RestaurantServiceTest {

    private static final Long RESTAURANT_ID = 1L;
    private static final String NAME = "Burger";
    private static final String DESCRIPTION = "Todo tipo de Hamburguesa";
    private static final String ADDRESS = "Av Peru";
    private static final String IMAGE = "www.image.com";

    private static final List<Turn> TURN_LIST = new ArrayList<>();
    private static final List<Reservation> RESERVATION_LIST = new ArrayList<>();
    private static final List<Board> BOARD_LIST = new ArrayList<>();
    private static final Restaurant RESTAURANT = new Restaurant();


    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        RESTAURANT.setName(NAME);
        RESTAURANT.setDescription(DESCRIPTION);
        RESTAURANT.setAddress(ADDRESS);
        RESTAURANT.setId(RESTAURANT_ID);
        RESTAURANT.setImage(IMAGE);
        RESTAURANT.setTurns(TURN_LIST);
        RESTAURANT.setBoards(BOARD_LIST);
        RESTAURANT.setReservations(RESERVATION_LIST);

    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
        restaurantService.getRestaurantById(RESTAURANT_ID);
    }

    @Test
    public void getRestaurantByIdTestError() {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty());
        Assertions.assertThrows(BookingException.class, () -> restaurantService.getRestaurantById(RESTAURANT_ID));
    }

    @Test
    public void getRestaurantsTest() throws BookingException {
        final Restaurant restaurant = new Restaurant();
        Mockito.when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
        final List<RestaurantRest> response = restaurantService.getRestaurants();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }
}
