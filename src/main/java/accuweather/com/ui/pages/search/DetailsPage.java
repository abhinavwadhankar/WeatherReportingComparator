package accuweather.com.ui.pages.search;

import accuweather.com.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage extends BasePage {

    public DetailsPage()
    {
        super();
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    @FindBy(xpath = "//span/span[text()='More Details']")
    protected WebElement moreDetailsLinkClick;

    @FindBy(xpath="//h2[contains(text(),'Current Weather')]/parent::div/div")
    protected  WebElement moreDetailsImagesClick;

    @FindBy(css = "div.display-temp")
    protected WebElement displayTempText;


}
