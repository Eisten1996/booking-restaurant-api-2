package pe.dipper.bookingrestaurantapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.dipper.bookingrestaurantapi.controllers.ReservationController;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.CreateReservationRest;
import pe.dipper.bookingrestaurantapi.jsons.ReservationRest;
import pe.dipper.bookingrestaurantapi.responses.BookingResponse;
import pe.dipper.bookingrestaurantapi.services.ReservationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 02/12/2020 - 16:20
 */
public class ReservationControllerTest {

    private static final String SUCCESS_STATUS = "Success";
    private static final String SUCCESS_CODE = "200 OK";
    private static final String OK = "OK";

    private static final Long RESTAURANT_ID = 1L;
    private static final Date DATE = new Date();
    private static final Long PERSON = 1L;
    private static final Long TURN_ID = 1L;
    private static final String LOCATOR = "BURGER 2";

    CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();
    ReservationRest RESERVATION_REST = new ReservationRest();

    @Mock
    ReservationService reservationService;

    @InjectMocks
    ReservationController reservationController;

    @BeforeEach
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        CREATE_RESERVATION_REST.setDate(DATE);
        CREATE_RESERVATION_REST.setPerson(PERSON);
        CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
        CREATE_RESERVATION_REST.setTurnId(TURN_ID);
    }

    @Test
    public void creationReservationTest() throws BookingException {
        Mockito.when(reservationService.createReservation(CREATE_RESERVATION_REST)).thenReturn(LOCATOR);
        final BookingResponse<String> response = reservationController.createReservation(CREATE_RESERVATION_REST);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), LOCATOR);

    }

    @Test
    public void getReservationIdTest() throws BookingException {
        Mockito.when(reservationService.getReservation(RESTAURANT_ID)).thenReturn(RESERVATION_REST);
        final BookingResponse<ReservationRest> response = reservationController.getReservationId(RESTAURANT_ID);
        assertEquals(response.getStatus(), SUCCESS_STATUS);
        assertEquals(response.getCode(), SUCCESS_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), RESERVATION_REST);
    }
}
