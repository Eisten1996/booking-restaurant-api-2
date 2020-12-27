package pe.dipper.bookingrestaurantapi.services.Impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.jsons.PaymentConfirmRest;
import pe.dipper.bookingrestaurantapi.jsons.PaymentIntentRest;
import pe.dipper.bookingrestaurantapi.services.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 17:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("$stripe.key.secretKey")
    String secretKey;

    public enum Currency {
        USD, EUR;
    }

    @Override
    public PaymentIntent paymentIntent(PaymentIntentRest paymentIntentRest) throws StripeException {
        Stripe.apiKey = secretKey;
        Map<String, Object> params = new HashMap<>();
        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("amount", paymentIntentRest.getPrice());
        params.put("currency", Currency.EUR);
        params.put("description", paymentIntentRest.getDescription());
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );
        return PaymentIntent.create(params);
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
