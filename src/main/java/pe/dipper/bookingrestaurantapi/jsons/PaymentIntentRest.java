package pe.dipper.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 17:30
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentIntentRest {

    private String description;

    private int price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
