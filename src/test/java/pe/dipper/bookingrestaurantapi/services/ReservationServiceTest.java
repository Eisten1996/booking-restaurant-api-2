package pe.dipper.bookingrestaurantapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.entities.Reservation;
import pe.dipper.bookingrestaurantapi.entities.Restaurant;
import pe.dipper.bookingrestaurantapi.entities.Turn;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.CreateReservationRest;
import pe.dipper.bookingrestaurantapi.jsons.ReservationRest;
import pe.dipper.bookingrestaurantapi.repositories.ReservationRepository;
import pe.dipper.bookingrestaurantapi.repositories.RestaurantRepository;
import pe.dipper.bookingrestaurantapi.repositories.TurnRepository;
import pe.dipper.bookingrestaurantapi.services.Impl.ReservationServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 03/12/2020 - 17:32
 */
public class ReservationServiceTest {

    private static final Long RESTAURANT_ID = 1L;
    private static final Long RESERVATION_ID = 1L;
    private static final Date DATE = new Date();
    private static final Long PERSON = 1L;
    private static final String EMAIL = "dipper@gmail.com";
    private static final String NAME_RESERVATION = "dipper";
    private static final boolean PAYMENT = true;
    private static final Long TURN_ID = 1L;

    private static final String NAME = "BURGER";
    private static final String DESCRIPTION = "Grandes hamburguesas";
    private static final String ADDRESS = "Calle Galindo";
    private static final String IMAGE = "www.image.com";
    private static final String LOCATOR = "BURGER 3";
    private static final String TURNO = "TURN_12_00";

    private static final CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();
    private static final Restaurant RESTAURANT = new Restaurant();
    private static final Turn TURN = new Turn();
    private static final Reservation RESERVATION = new Reservation();
    private static final ReservationRest RESERVATION_REST = new ReservationRest();

    private static final List<Turn> TURN_LIST = new ArrayList<>();

    private static final Optional<Restaurant> OPTIONAL_RESTAURANT = Optional.of(RESTAURANT);
    private static final Optional<Restaurant> OPTIONAL_RESTAURANT_EMPTY = Optional.empty();
    private static final Optional<Turn> OPTIONAL_TURN = Optional.of(TURN);
    private static final Optional<Turn> OPTIONAL_TURN_EMPTY = Optional.empty();
    private static final Optional<Reservation> OPTIONAL_RESERVATION_EMPTY = Optional.empty();
    private static final Optional<Reservation> OPTIONAL_RESERVATION = Optional.of(RESERVATION);

    @Mock
    ReservationRepository reservationRepository;

    @Mock
    RestaurantRepository restaurantRepository;

    @Mock
    EmailService emailService;

    @Mock
    TurnRepository turnRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        RESTAURANT.setName(NAME);
        RESTAURANT.setDescription(DESCRIPTION);
        RESTAURANT.setAddress(ADDRESS);
        RESTAURANT.setId(RESTAURANT_ID);
        RESTAURANT.setImage(IMAGE);
        RESTAURANT.setTurns(TURN_LIST);

        RESERVATION.setId(RESERVATION_ID);
        RESERVATION.setDate(DATE);
        RESERVATION.setLocator(LOCATOR);
        RESERVATION.setTurn(TURNO);
        RESERVATION.setRestaurant(RESTAURANT);
        RESERVATION.setEmail(EMAIL);
        RESERVATION.setName(NAME_RESERVATION);
        RESERVATION.setPayment(PAYMENT);

        CREATE_RESERVATION_REST.setDate(DATE);
        CREATE_RESERVATION_REST.setPerson(PERSON);
        CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
        CREATE_RESERVATION_REST.setTurnId(TURN_ID);
        CREATE_RESERVATION_REST.setEmail(EMAIL);
        CREATE_RESERVATION_REST.setName(NAME_RESERVATION);
    }

    @Test
    public void getReservationTest() throws BookingException {

        Mockito.when(reservationRepository.findById(RESERVATION_ID)).thenReturn(OPTIONAL_RESERVATION);
        reservationService.getReservation(RESERVATION_ID);
    }


    @Test
    public void createReservationTest() throws BookingException {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
        Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
        Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT_ID)).thenReturn(OPTIONAL_RESERVATION_EMPTY);
        Mockito.when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(new Reservation());
        reservationService.createReservation(CREATE_RESERVATION_REST);
    }

    @Test
    public void createReservationFindByIdTestError() {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT_EMPTY);
        Assertions.assertThrows(BookingException.class, () -> reservationService.createReservation(CREATE_RESERVATION_REST));
    }

    @Test
    public void createReservationTurnFindByIdTestError() {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
        Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN_EMPTY);
        Assertions.assertThrows(BookingException.class, () -> reservationService.createReservation(CREATE_RESERVATION_REST));
    }

    @Test
    public void createReservationTurnAndRestaurantIdTestError() {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
        Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
        Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId())).thenReturn(OPTIONAL_RESERVATION);
        Assertions.assertThrows(BookingException.class, () -> reservationService.createReservation(CREATE_RESERVATION_REST));
    }

    @Test
    public void createReservationInternalServerErrorTestError() {

        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
        Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
        Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
                .thenReturn(OPTIONAL_RESERVATION_EMPTY);
        Mockito.doThrow(Exception.class).when(reservationRepository).save(Mockito.any(Reservation.class));
        Assertions.assertThrows(BookingException.class, () -> reservationService.createReservation(CREATE_RESERVATION_REST));
    }
}
