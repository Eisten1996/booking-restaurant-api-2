package pe.dipper.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 20/11/2020 - 22:18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

    @JsonProperty("locator")
    private String locator;

    @JsonProperty("restaurantId")
    private Long restaurantId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId;

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getTurnId() {
        return turnId;
    }

    public void setTurnId(Long turnId) {
        this.turnId = turnId;
    }
}
