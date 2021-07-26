package tests;

import accuweather.com.api.servicesteps.OpenWeatherMapAPIStep;
import accuweather.com.ui.actions.search.DetailsActions;
import accuweather.com.ui.actions.search.SearchActions;
import accuweather.com.ui.utilites.PropertyLoad;
import accuweather.com.ui.utilites.WeatherReportComparator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidationWeatherTemp {


    public SearchActions  searchActions;
    public DetailsActions detailsActions;
    public WeatherReportComparator reportComparator;

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
        String city = "Bangalore";
        searchActions = new SearchActions();
        searchActions.openUrl(PropertyLoad.getProperties().getProperty("url.accuweather"));
        detailsActions = searchActions.searchCity(city);
        detailsActions.clickDMoreDetailsImageLink();
        //detailsActions.clickDMoreDetailsLink();
        Double temp = detailsActions.getCityTemp();
        System.out.println("temp :"+ temp);
        openWeatherMapAPIStep.postCityAndAPPIDCall(city);
       // reportComparator.compare(detailsActions.getCityTemp(),26.00);
    }

    @AfterMethod
    public void closeSetup() throws IOException {
        searchActions.closeBrowser();
    }

}
