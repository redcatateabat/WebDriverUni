import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.util.ArrayList;
import java.util.List;

public class ActionsTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    Actions actions = new Actions(Browser.getBrowser());

    @Test
    public void dragAndDropTest() {

        scrollAndGoTo(wdu.getHomepage().getActionsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));

        Assert.assertEquals("DROP HERE!", wdu.getActions().getDropHereBox().getText());
        actions.dragAndDrop(wdu.getActions().getDragBox(), wdu.getActions().getDropHereBox()).perform();
        Assert.assertEquals("Dropped!", wdu.getActions().getDropHereBox().getText());
    }

    @Test
    public void doubleClickTest(){

        scrollAndGoTo(wdu.getHomepage().getActionsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));

        WebElement attribute = Browser.getBrowser().findElementById("double-click");
        String value = attribute.getAttribute("class");
        Assert.assertEquals("div-double-click", value);

        actions.doubleClick(wdu.getActions().getDoubleClick()).perform();
        String value2 = attribute.getAttribute("class");
        Assert.assertEquals("div-double-click double", value2);
    }

    @Test
    public void hoverTest(){

        scrollAndGoTo(wdu.getHomepage().getActionsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));

        List<WebElement> allButtons = Browser.getBrowser().findElementsByXPath("//div[@id=\"div-hover\"]/div");
        for (int i=0; i<allButtons.size(); i++) {

            WebElement hoverButton = allButtons.get(i);
            actions.moveToElement(hoverButton).perform();

            List<WebElement> links = Browser.getBrowser().findElementsByCssSelector("a.list-alert");
            actions.click(links.get(i)).perform();
            Browser.getBrowser().switchTo().alert().accept();
        }
    }

    @Test
    public void clickAndHoldTest(){

        scrollAndGoTo(wdu.getHomepage().getActionsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));

        actions.clickAndHold(wdu.getActions().getClickHold()).perform();
        Assert.assertEquals("Well done! keep holding that click now.....", wdu.getActions().getClickHold().getText());
    }
}
