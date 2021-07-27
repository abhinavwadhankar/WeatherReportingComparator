package accuweather.com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage{

    public CommonPage()
    {
        super();
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    @FindBy(xpath = "//ins/div/iframe[contains(@id,'google_ads_iframe')]")
    protected  WebElement iFrameOfAds;

    @FindBy(id="dismiss-button")
    protected WebElement dismissAddWindow;

}
