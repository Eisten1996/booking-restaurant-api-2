package pe.dipper.bookingrestaurantapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pe.dipper.bookingrestaurantapi.dtos.EmailTemplateDto;
import pe.dipper.bookingrestaurantapi.entities.Notification;
import pe.dipper.bookingrestaurantapi.exceptions.BookingException;
import pe.dipper.bookingrestaurantapi.exceptions.InternalServerErrorException;
import pe.dipper.bookingrestaurantapi.exceptions.NotFoundException;
import pe.dipper.bookingrestaurantapi.repositories.NotificationRepository;
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

    @Autowired
    private NotificationRepository notificationRepository;

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

    private EmailTemplateDto findTemplateAndReplace(final String templateCode, final String currentName) throws BookingException {

        final Notification notificationTemplate = notificationRepository.findByTemplateType(templateCode)
                .orElseThrow(() -> new NotFoundException("TEMPLATE_NOT_FOUND", "CODE_TEMPLATE_NOT_FOUND"));

        final EmailTemplateDto emailTemplateDto = new EmailTemplateDto();
        emailTemplateDto.setSubject(currentName);
        emailTemplateDto.setTemplate(notificationTemplate.getTemplate().replaceAll("\\{" + "name" + "\\}", currentName));
        return emailTemplateDto;
    }
}
