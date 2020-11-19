package pe.dipper.bookingrestaurantapi.dtos;

import java.io.Serializable;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 18/11/2020 - 21:47
 */
public class ErrorDto implements Serializable {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public ErrorDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
