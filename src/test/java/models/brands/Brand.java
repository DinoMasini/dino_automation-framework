package models.brands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Brand {

    private int id;
    @JsonProperty("brand")
    private String name;
}
