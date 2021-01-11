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
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.repositories.ReservationRepository;
import pe.dipper.bookingrestaurantapi.services.Impl.CancelReservationServiceImpl;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 09/12/2020 - 20:18
 */
public class CancelReservationServiceTest {

    private static final String LOCATOR = "BURGER 7";
    private static final String RESERVATION_DELETED = "LOCATOR_DELETED";
    private static final Reservation RESERVATION = new Reservation();
    private static final Restaurant RESTAURANT = new Restaurant();

    private static final Long RESERVATION_ID = 1L;
    private static final Date DATE = new Date();
    private static final String EMAIL = "dipper@gmail.com";
    private static final String NAME_RESERVATION = "dipper";
    private static final boolean PAYMENT = true;
    private static final String TURNO = "TURN_12_00";

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private CancelReservationServiceImpl cancelReservationService;

    @Mock
    EmailService emailService;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        RESERVATION.setId(RESERVATION_ID);
        RESERVATION.setDate(DATE);
        RESERVATION.setLocator(LOCATOR);
        RESERVATION.setTurn(TURNO);
        RESERVATION.setRestaurant(RESTAURANT);
        RESERVATION.setEmail(EMAIL);
        RESERVATION.setName(NAME_RESERVATION);
        RESERVATION.setPayment(PAYMENT);
    }

    @Test
    public void deleteReservationOK() throws BookingException {
        Mockito.when(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));
        Mockito.when(reservationRepository.deleteByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));
        final String response = cancelReservationService.deleteReservation(LOCATOR);
        assertEquals(response, RESERVATION_DELETED);
    }

    @Test
    public void deleteReservationNotFountError() throws BookingException {
        Mockito.when(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.empty());
        Mockito.when(reservationRepository.deleteByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));

        Assertions.assertThrows(BookingException.class, () -> {
            final String response = cancelReservationService.deleteReservation(LOCATOR);
            assertEquals(response, RESERVATION_DELETED);
        });
    }

    @Test
    public void deleteReservationInternalServerError() throws BookingException {
        Mockito.when(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));
        Assertions.assertThrows(BookingException.class, () -> {
            Mockito.doThrow(Exception.class).when(reservationRepository).deleteByLocator(LOCATOR);
            final String response = cancelReservationService.deleteReservation(LOCATOR);
            assertEquals(response, RESERVATION_DELETED);
        });
    }
}
