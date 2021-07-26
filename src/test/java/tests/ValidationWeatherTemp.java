package tests;

import accuweather.com.api.servicesteps.OpenWeatherMapAPIStep;
import accuweather.com.ui.actions.search.DetailsActions;
import accuweather.com.ui.actions.search.SearchActions;
import accuweather.com.ui.utilites.PropertyLoad;
import accuweather.com.ui.utilites.WeatherReportComparator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class ValidationWeatherTemp {


    public SearchActions  searchActions;
    public DetailsActions detailsActions;
    public WeatherReportComparator reportComparator;
    public OpenWeatherMapAPIStep weatherMapAPIStep;
    public String city = "Bangalore";

    /*API Step*/
    OpenWeatherMapAPIStep openWeatherMapAPIStep=new OpenWeatherMapAPIStep();

    @BeforeTest
    public void initialSetUp()
    {
        reportComparator = new WeatherReportComparator();
    }

    @Test
    public void testTempValidation()
    {
       /*UI test*/
        searchActions = new SearchActions();
        searchActions.openUrl(PropertyLoad.getProperties().getProperty("url.accuweather"));
        detailsActions = searchActions.searchCity(city);
        detailsActions.clickDMoreDetailsImageLink();
        BigDecimal tempUI = detailsActions.getCityTemp();
        System.out.println("temp :"+ tempUI);
        openWeatherMapAPIStep.getCityAndAPPIDCall(city);

        /*API test*/
        weatherMapAPIStep =new OpenWeatherMapAPIStep();
        Response response = weatherMapAPIStep.getCityAndAPPIDCall(city);
        BigDecimal mwTemp = weatherMapAPIStep.returnTemperature(response);
        /*Compare Logic */
        int result = reportComparator.compare(tempUI,mwTemp);
            if(result==1)
            Assert.assertTrue(Boolean.TRUE,"Temperature variation is in between 2 degree");
            else
            Assert.assertTrue(Boolean.FALSE,"Temperature variation is more than 2 degree");
    }

    @AfterMethod
    public void closeSetup() throws IOException {
        searchActions.closeBrowser();
    }

}
