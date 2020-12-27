package pe.dipper.bookingrestaurantapi.services.Impl;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.jsons.PaymentConfirmRest;
import pe.dipper.bookingrestaurantapi.jsons.PaymentIntentRest;
import pe.dipper.bookingrestaurantapi.services.PaymentService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 17:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("$stripe.key.secretKey")
    String secretKey;

    @Override
    public PaymentIntent paymentIntent(PaymentIntentRest paymentIntentRest) throws StripeException {
        return null;
    }

    @Override
    public PaymentIntent paymentConfirm(PaymentConfirmRest paymentConfirmRest) throws StripeException {
        return null;
    }

    @Override
    public PaymentIntent paymentCancel(String paymentId) throws StripeException {
        return null;
    }
}
