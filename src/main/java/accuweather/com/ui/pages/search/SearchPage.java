package accuweather.com.ui.pages.search;

import accuweather.com.ui.actions.search.SearchActions;
import accuweather.com.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    public SearchPage()
    {
        super();
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    @FindBy(xpath="//input[@placeholder='Search Location']")
    protected WebElement searchCityText;

    @FindBy(xpath ="//*[@data-qa='searchIcon']")
    protected WebElement searchIonClick;

}
