package accuweather.com.ui.pages.search;

import accuweather.com.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath="//input[@placeholder='Search Location']")
    protected WebElement searchCityText;

    @FindBy(xpath ="//*[@data-qa='searchIcon']")
    protected WebElement searchIonClick;

}
