package accuweather.com.ui.actions.search;

import accuweather.com.ui.pages.BasePage;
import accuweather.com.ui.pages.search.DetailsPage;
import accuweather.com.ui.utilites.ActionUtils;
import org.openqa.selenium.support.PageFactory;

public class DetailsActions extends DetailsPage {

    public DetailsActions()
    {
        super();
    }

    private ActionUtils actionUtils = new ActionUtils();

    public void clickDMoreDetailsLink()
    {
        actionUtils.waitForVisibilityOfElement(moreDetailsLinkClick);
        this.moreDetailsLinkClick.click();
    }


    public void clickDMoreDetailsImageLink()
    {
        actionUtils.waitForVisibilityOfElement(moreDetailsImagesClick);
        this.moreDetailsImagesClick.click();
    }
    public Double getCityTemp()
    {
        actionUtils.waitForVisibilityOfElement(displayTempText);
        return Double.parseDouble(this.displayTempText.getText().replace("°","").replace("C",""));
    }

}

