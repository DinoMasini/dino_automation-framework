package tests.api;

import facade.GetBrands;
import models.brands.Brand;
import models.brands.BrandResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log;

import java.util.List;

public class BrandTest {

    @Test
    public void testGetBrands() {
        GetBrands getBrands = new GetBrands();
        getBrands.setEndpointPath();
        BrandResponse response = getBrands.sendRequest();

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertNotNull(response.getBrands());
        Assert.assertFalse(response.getBrands().isEmpty());

        // Estrazione della lista dei brand
        List<Brand> brands = response.getBrands();
        Log.info("Totale brand trovati: " + brands.size());

        // Iterazione sui brand e stampa dei dettagli
        for (Brand b : brands) {
            Assert.assertNotNull(b.getId(), "Brand ID should not be null");
            Log.info("ID: " + b.getId() + " | Brand: " + b.getName());
        }
    }
}

