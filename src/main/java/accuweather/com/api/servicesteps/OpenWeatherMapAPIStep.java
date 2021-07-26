package accuweather.com.api.servicesteps;

import accuweather.com.api.BaseURI.OpenWeatherMapURLS;
import accuweather.com.ui.utilites.PropertyLoad;
import accuweather.com.utilites.TestConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherMapAPIStep {

    private OpenWeatherMapURLS mapURLS = new OpenWeatherMapURLS();

    public void postCityAndAPPIDCall(String city)
    {
        RestAssured.baseURI = TestConstants.securityHttps +
                PropertyLoad.getProperties().getProperty("uri.openweathermap");

        Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .queryParam("q",city)
                .queryParam("appid", PropertyLoad.getProperties().getProperty("key.api.appid"))
                .log().all()
                .get(mapURLS.postTempURI)
                .then().log().all()
                .extract()
                .response();

    }

}
