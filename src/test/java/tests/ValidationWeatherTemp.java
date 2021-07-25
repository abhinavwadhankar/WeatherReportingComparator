package tests;

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
    public WeatherReportComparator reportComparator = new WeatherReportComparator();

    public PropertyLoad propertyLoad;

    @BeforeTest
    public void initialSetUp()
    {
        try {
            propertyLoad =new PropertyLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTempValidation()
    {
        searchActions = new SearchActions();
        searchActions.openUrl(propertyLoad.getProperties().getProperty("url.accuweather"));
        detailsActions = searchActions.searchCity("Bangalore");
        detailsActions.clickDMoreDetailsLink();
       // reportComparator.compare(detailsActions.getCityTemp(),26.00);
    }

    @AfterMethod
    public void closeSetup() throws IOException {
        searchActions.closeBrowser();
        propertyLoad.closeFiles();
    }

}
