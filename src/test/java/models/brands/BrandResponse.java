package models.brands;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandResponse {

    private int responseCode;
    private List<Brand> brands;
}
