package facade;

import base.IRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.brands.BrandResponse;
import utils.DataUtils;
import utils.JsonUtils;

public class GetBrands implements IRequest<BrandResponse> {

    private String endpointPath;

    @Override
    public BrandResponse sendRequest() {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpointPath);

        String json = response.getBody().asString(); // È già JSON, non c'è bisogno di parsing

        try {
            return JsonUtils.getObjectMapper().readValue(json, BrandResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nel parsing JSON: " + e.getMessage());
        }
    }


    @Override
    public void setEndpointPath() {
        this.endpointPath = DataUtils.getBrandsUrl();
    }
}
