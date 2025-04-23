package models.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String name;
    private String price;
    private String brand;
    private Category category;
}
