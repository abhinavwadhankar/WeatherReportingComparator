package accuweather.com.ui.actions;

import accuweather.com.ui.pages.BasePage;
import accuweather.com.ui.pages.CommonPage;
import accuweather.com.ui.utilites.ActionUtils;

import java.util.Set;

public class CommonActions extends CommonPage {

    public CommonActions() {
        super();
    }

    private ActionUtils actionUtils = new ActionUtils();

    public void closeAdvertiseWindow()
    {   this.getDriver().switchTo().frame(iFrameOfAds);
        if(!actionUtils.checkVisibilityOfElement(this.dismissAddWindow))
             this.dismissAddWindow.click();
        this.getDriver().switchTo().parentFrame();
    }
}
