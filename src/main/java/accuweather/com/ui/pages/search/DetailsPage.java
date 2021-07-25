package accuweather.com.ui.pages.search;

import accuweather.com.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Clouds and sun']/following-sibling::span/span[text()='More Details']")
    protected WebElement moreCloudAndSunDetailsLinkClick;

    @FindBy(css = "div.display-temp")
    protected WebElement displayTempText;


}
