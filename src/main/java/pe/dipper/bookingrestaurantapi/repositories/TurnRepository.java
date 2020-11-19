package pe.dipper.bookingrestaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.dipper.bookingrestaurantapi.entities.Turn;

import java.util.Optional;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 21:24
 */
@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    Optional<Turn> findById(Long id);
}
