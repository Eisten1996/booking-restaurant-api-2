package pe.dipper.bookingrestaurantapi.services.Impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.entities.Reservation;
import pe.dipper.bookingrestaurantapi.entities.Restaurant;
import pe.dipper.bookingrestaurantapi.entities.Turn;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.exceptions.InternalServerErrorException;
import pe.dipper.bookingrestaurantapi.exceptions.NotFoundException;
import pe.dipper.bookingrestaurantapi.jsons.CreateReservationRest;
import pe.dipper.bookingrestaurantapi.jsons.ReservationRest;
import pe.dipper.bookingrestaurantapi.repositories.ReservationRepository;
import pe.dipper.bookingrestaurantapi.repositories.RestaurantRepository;
import pe.dipper.bookingrestaurantapi.repositories.TurnRepository;
import pe.dipper.bookingrestaurantapi.services.ReservationService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 20/11/2020 - 22:25
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TurnRepository turnRepository;

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Override
    public ReservationRest getReservation(Long reservationId) throws BookingException {
        return MODEL_MAPPER.map(getReservationEntity(reservationId), ReservationRest.class);
    }

    @Override
    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {
        final Restaurant restaurantId = restaurantRepository
                .findById(createReservationRest
                        .getRestaurantId())
                .orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

        final Turn turn = turnRepository
                .findById(createReservationRest
                        .getTurnId())
                .orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

        if (reservationRepository.findByTurnAndRestaurantId(turn.getName(),restaurantId.getId()).isPresent()){
            throw new NotFoundException("RESERVATION_ALREADT_EXIST","RESERVATION_ALREADT_EXIST");
        }

        String locator = generateLocator(restaurantId, createReservationRest);
        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setDate(createReservationRest.getDate());
        reservation.setName(createReservationRest.getName());
        reservation.setEmail(createReservationRest.getEmail());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());

        try {
            reservationRepository.save(reservation);
        } catch (final Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return locator;
    }

    private Reservation getReservationEntity(Long reservationId) throws BookingException {
        return reservationRepository
                .findById(reservationId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESERVATION_NOT_FOUND"));
    }

    private String generateLocator(
            Restaurant restaurantId,
            CreateReservationRest createReservationRest) throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }
}
