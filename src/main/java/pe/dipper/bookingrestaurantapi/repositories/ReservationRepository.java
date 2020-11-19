package pe.dipper.bookingrestaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import pe.dipper.bookingrestaurantapi.entities.Reservation;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 21:16
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);

    Optional<Reservation> findByLocator(String locator);

    @Modifying
    @Transactional
    Optional<Reservation> deleteByLocator(String locator);

    Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);


}
