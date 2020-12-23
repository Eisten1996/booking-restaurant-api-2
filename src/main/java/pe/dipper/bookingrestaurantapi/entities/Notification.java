package pe.dipper.bookingrestaurantapi.entities;

import javax.persistence.*;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 22/12/2020 - 23:11
 */
@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TEMPLATE")
    private String template;

    @Column(name = "TEMPLATE_TYPE")
    private String templateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
}
