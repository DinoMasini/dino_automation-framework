package models.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponse {

    private int responseCode;
    private List<Product> products;
}
