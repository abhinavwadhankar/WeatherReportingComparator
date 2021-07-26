package accuweather.com.api.servicesteps;

import accuweather.com.api.BaseURI.OpenWeatherMapURLS;
import accuweather.com.api.pojos.Response.WeatherResponsePojo;
import accuweather.com.ui.utilites.PropertyLoad;
import accuweather.com.utilites.TestConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.math.BigDecimal;

public class OpenWeatherMapAPIStep {

    private OpenWeatherMapURLS mapURLS = new OpenWeatherMapURLS();

    public Response getCityAndAPPIDCall(String city)
    {
        RestAssured.baseURI = TestConstants.securityHttps +
                PropertyLoad.getProperties().getProperty("uri.openweathermap");

       return RestAssured.given().log().all()
                .contentType("application/json")
                .queryParam("q",city)
                .queryParam("appid", PropertyLoad.getProperties().getProperty("key.api.appid"))
                .log().all()
                .get(mapURLS.postTempURI)
                .then().log().all()
                .extract()
                .response();
    }

    public BigDecimal returnTemperature(Response response)
    {
        WeatherResponsePojo weatherResponsePojo=response.as(WeatherResponsePojo.class);
        return weatherResponsePojo.getMain().getTemp();
    }

}
