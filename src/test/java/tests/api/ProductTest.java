package tests.api;

import facade.GetProducts;
import lombok.SneakyThrows;
import models.Product;
import models.ProductResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void testGetProducts() {
        GetProducts getProducts = new GetProducts();
        getProducts.setEndpointPath();
        ProductResponse response = getProducts.sendRequest();

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertNotNull(response.getProducts());
        Assert.assertFalse(response.getProducts().isEmpty());

        /*
        //OUTPUT DI DEBUG
        System.out.println("Totale prodotti ricevuti: " + response.getProducts().size());

        for (Product p : response.getProducts()) {
            System.out.println("Prodotto: " + p.getName() + " - Brand: " + p.getBrand());
        }
        */

    }
}
