package pe.dipper.bookingrestaurantapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.exceptions.InternalServerErrorException;
import pe.dipper.bookingrestaurantapi.services.EmailService;

import javax.mail.internet.MimeMessage;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 25/12/2020 - 22:24
 */

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String processSendEmail(String receiver, String subject, String templateCode, String currentName) throws BookingException {

        return null;
    }

    private void sendEmail(final String receiver, final String subject, final String template) throws BookingException {
        final MimeMessage email = javaMailSender.createMimeMessage();
        final MimeMessageHelper content;
        try {
            content = new MimeMessageHelper(email, true);
            content.setSubject(subject);
            content.setTo(receiver);
            content.setText(template, true);
        } catch (Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        javaMailSender.send(email);
    }
}
