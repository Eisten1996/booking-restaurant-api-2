package pe.dipper.bookingrestaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.dipper.bookingrestaurantapi.entities.Restaurant;

import java.util.List;
import java.util.Optional;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 17:03
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Override
    Optional<Restaurant> findById(Long id);

    Optional<Restaurant> findByName(String nameRestaurant);

    @Query("SELECT REST from Restaurant REST")
    public List<Restaurant> findRestaurants();
}
