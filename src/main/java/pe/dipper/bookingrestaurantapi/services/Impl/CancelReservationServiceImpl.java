package pe.dipper.bookingrestaurantapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.exceptions.InternalServerErrorException;
import pe.dipper.bookingrestaurantapi.exceptions.NotFoundException;
import pe.dipper.bookingrestaurantapi.repositories.ReservationRepository;
import pe.dipper.bookingrestaurantapi.services.CancelReservationService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 21/11/2020 - 18:12
 */
@Service
public class CancelReservationServiceImpl implements CancelReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public String deleteReservation(String locator) throws BookingException {

        reservationRepository
                .findByLocator(locator)
                .orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

        try {
            reservationRepository.deleteByLocator(locator);
        } catch (final Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "LOCATOR_DELETED";
    }
}
