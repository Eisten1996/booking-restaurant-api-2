package pe.dipper.bookingrestaurantapi.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 17:02
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "LOCATOR")
    private String locator;

    @Column(name = "PERSON")
    private Long person;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAUTANT_ID", nullable = false)
    private Restaurant restaurant;
}
