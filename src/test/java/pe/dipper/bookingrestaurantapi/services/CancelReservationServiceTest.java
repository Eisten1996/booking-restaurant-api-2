package pe.dipper.bookingrestaurantapi.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.entities.Reservation;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.repositories.ReservationRepository;
import pe.dipper.bookingrestaurantapi.services.Impl.CancelReservationServiceImpl;

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

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private CancelReservationServiceImpl cancelReservationService;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteReservationOK() throws BookingException {
        Mockito.when(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));
        Mockito.when(reservationRepository.deleteByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION));
        final String response = cancelReservationService.deleteReservation(LOCATOR);
        assertEquals(response,RESERVATION_DELETED);
    }
}
