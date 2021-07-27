package accuweather.com.ui.utilites;

import accuweather.com.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashSet;
import java.util.Set;

public class ActionUtils extends BasePage{

    public void waitForVisibilityOfElement(WebElement element)
    {
        WebDriverWait driverWait = new WebDriverWait(this.getDriver(),60);
        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e)
        {
            System.out.println("Element is not visible");
        }
    }

    public Boolean checkVisibilityOfElement(WebElement element)
    {
        WebDriverWait driverWait = new WebDriverWait(this.getDriver(),10);
        try {
            return driverWait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (Exception e)
        {
            System.out.println("Element is visible");
            return Boolean.FALSE;
        }
    }

    public void threadSleepMilliSeconds(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void threadSleepSeconds(int time)
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void declinedCookiesDialogBox()
    {
        this.getDriver().switchTo().alert().dismiss();
    }

    public void acceptCookiesDialogBox()
    {
        this.getDriver().switchTo().alert().accept();
    }
}
