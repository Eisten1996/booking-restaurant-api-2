package pe.dipper.bookingrestaurantapi.dtos;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 25/12/2020 - 23:05
 */
public class EmailTemplateDto {

    private long Id;
    private String template;
    private String subject;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    private String templateCode;
}
