package pe.dipper.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 17:35
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentConfirmRest {

    private String paymentId;

    private String name;

    private String email;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
