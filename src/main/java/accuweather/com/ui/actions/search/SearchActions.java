package accuweather.com.ui.actions.search;

import accuweather.com.ui.pages.BasePage;
import accuweather.com.ui.pages.search.SearchPage;
import accuweather.com.ui.utilites.ActionUtils;
import org.openqa.selenium.support.PageFactory;

public class SearchActions extends SearchPage {

    public SearchActions()
    {
        super();
    }
    private ActionUtils actionUtils =new ActionUtils();

    public DetailsActions searchCity(String city)
    {
        actionUtils.waitForVisibilityOfElement(searchCityText);

        this.searchCityText.sendKeys(city);
        this.searchIonClick.click();
        return new DetailsActions();
    }

}
