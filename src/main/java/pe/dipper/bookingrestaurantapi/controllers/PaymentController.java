package pe.dipper.bookingrestaurantapi.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.dipper.bookingrestaurantapi.jsons.PaymentIntentRest;
import pe.dipper.bookingrestaurantapi.services.PaymentService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 27/12/2020 - 21:16
 */
@RestController()
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/paymentIntent",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> paymentIntent(@RequestBody PaymentIntentRest paymentIntentRest) throws StripeException {
        PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentRest);

        String paymentString = paymentIntent.toJson();

        return new ResponseEntity<String>(paymentString, HttpStatus.OK);
    }
}
