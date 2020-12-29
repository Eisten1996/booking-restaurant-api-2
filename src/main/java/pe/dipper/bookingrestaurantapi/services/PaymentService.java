package pe.dipper.bookingrestaurantapi.services;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.jsons.PaymentConfirmRest;
import pe.dipper.bookingrestaurantapi.jsons.PaymentIntentRest;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 17:21
 */
public interface PaymentService {

    public PaymentIntent paymentIntent(PaymentIntentRest paymentIntentRest) throws StripeException;

    public PaymentIntent paymentConfirm(PaymentConfirmRest paymentConfirmRest) throws StripeException, BookingException;

    public PaymentIntent paymentCancel(String paymentId) throws StripeException;
}
