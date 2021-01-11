package pe.dipper.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Dipper
 * @project booking-restaurant-api
 * @created 19/11/2020 - 23:36
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String image;

    @JsonProperty("turns")
    private List<TurnRest> turns;

    @JsonProperty("price")
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<TurnRest> getTurns() {
        return turns;
    }

    public void setTurns(List<TurnRest> turns) {
        this.turns = turns;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
