package pe.dipper.bookingrestaurantapi.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.services.EmailService;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 25/12/2020 - 22:24
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String processSendEmail(String receiver, String subject, String templateCode, String currentName) throws BookingException {

        return null;
    }
}
