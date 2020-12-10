package pe.dipper.bookingrestaurantapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.controllers.CancelReservationController;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.CancelReservationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 08/12/2020 - 21:59
 */
public class CancelReservationControllerTest {

    private static final String LOCATOR = "BURGER 7";
    private static final String RESERVATION_DELETED = "LOCATOR_DELETED";

    private static final String SUCCESS_STATUS = "Success";
    private static final String SUCCESS_CODE = "200 OK";
    private static final String OK = "OK";

    @Mock
    CancelReservationService cancelReservationService;

    @InjectMocks
    CancelReservationController cancelReservationController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteReservationTest() throws BookingException {
        Mockito.when(cancelReservationService.deleteReservation(LOCATOR)).thenReturn(RESERVATION_DELETED);
        final BookingResponse<String> response = cancelReservationController.deleteReservation(LOCATOR);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESERVATION_DELETED);
    }
}
