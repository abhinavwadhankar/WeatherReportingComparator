package accuweather.com.ui.actions.search;

import accuweather.com.ui.pages.search.SearchPage;

public class SearchActions extends SearchPage {

    public DetailsActions searchCity(String city)
    {
        this.searchCityText.sendKeys(city);
        this.searchIonClick.click();
        return new DetailsActions();
    }



}
