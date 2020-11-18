package pe.dipper.bookingrestaurantapi.entities;

import javax.persistence.*;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 17:01
 */
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE")
    private String image;
}
