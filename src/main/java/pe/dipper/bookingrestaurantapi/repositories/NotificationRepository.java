package pe.dipper.bookingrestaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.dipper.bookingrestaurantapi.entities.Notification;

import java.util.Optional;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 22/12/2020 - 23:21
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByTemplateCode(String templateType);
}
