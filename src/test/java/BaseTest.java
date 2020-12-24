import browser.Browser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.util.ArrayList;

public class BaseTest {

    @BeforeClass
    public static void openBrowser() {
        Browser.getBrowser().get("http://webdriveruniversity.com/index.html");
        Browser.getBrowser().manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser(){
        Browser.getBrowser().quit();
    }

    public static void switchTab(){

        ArrayList tabs = new ArrayList(Browser.getBrowser().getWindowHandles());
        Browser.getBrowser().switchTo().window((String) tabs.get(1));
    }

    @After
    public void goToHomeTab(){
        ArrayList tabs = new ArrayList(Browser.getBrowser().getWindowHandles());
        Browser.getBrowser().switchTo().window((String) tabs.get(0));
    }

    public boolean isAccordionOpen(String xpath) {
        if (Browser.getBrowser().findElementByXPath(xpath).getAttribute("class").contains("accordion active")){
            return true;
        }
        else return false;

    }

    public static void scrollAndGoTo(WebElement link){

        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"Accordion/index.html\"]")));

        Browser.getBrowser().executeScript("arguments[0].scrollIntoView(false);", link);
        link.click();
        switchTab();
    }

    public static String getDateFieldValue() {
        return Browser.getBrowser().findElementByCssSelector("div#datepicker>input").getAttribute("value");
    }

}
