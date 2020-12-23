package pages;

import browser.Browser;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebElement findElement(String xpath){

        return Browser.getBrowser().findElementByXPath(xpath);
}
}
