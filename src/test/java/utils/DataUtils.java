package utils;

public class DataUtils {

    public static String getProductsUrl() {
        String baseUrl = ConfigReader.get("api.baseUrl");
        return baseUrl + "/productsList";
    }

    public static String getBrandsUrl(){
        String baseUrl = ConfigReader.get("api.baseUrl");
        return baseUrl + "/brandsList";
    }
}
