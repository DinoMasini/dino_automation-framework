package facade;

import base.IRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.ProductResponse;
import utils.DataUtils;

public class GetProducts implements IRequest<ProductResponse> {

    private String endpointPath;

    @Override
    public ProductResponse sendRequest() {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpointPath);

        String htmlBody = response.getBody().asString();

        // Estrai solo il JSON da <body>{...}</body>
        String json = htmlBody.replaceAll("(?s).*<body>(\\{.*?})</body>.*", "$1");

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, ProductResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nella deserializzazione JSON: " + e.getMessage());
        }
    }


    @Override
    public void setEndpointPath() {
        this.endpointPath = DataUtils.getProductsUrl();
    }
}

