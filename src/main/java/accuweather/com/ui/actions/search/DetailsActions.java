package accuweather.com.ui.actions.search;

import accuweather.com.ui.pages.search.DetailsPage;

public class DetailsActions extends DetailsPage {


    public void clickDMoreDetailsLink()
    {
        this.moreCloudAndSunDetailsLinkClick.click();
    }

    public Double getCityTemp()
    {
        return Double.parseDouble(this.displayTempText.getText().replace("°",""));
    }

}

