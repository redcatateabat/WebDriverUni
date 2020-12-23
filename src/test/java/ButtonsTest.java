import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

public class ButtonsTest  extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void webElementClickTest(){
        scrollAndGoTo(wdu.getHomepage().getButtonsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Lets Get Clicking!']")));

        wdu.getButtons().getButton1().click();
        Assert.assertEquals("Congratulations!", wdu.getButtons().findElement("//h4[text()='Congratulations!']").getText());
        wdu.getButtons().getCloseButton1().click();
    }

    @Test
    public void javaScriptClickTest() {
        scrollAndGoTo(wdu.getHomepage().getButtonsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Lets Get Clicking!']")));

        WebElement button = Browser.getBrowser().findElement(By.cssSelector("span#button2"));
        JavascriptExecutor js = Browser.getBrowser();
        js.executeScript("arguments[0].click();", button);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='It’s that Easy!!  Well I think it is.....']")));
        Assert.assertEquals("It’s that Easy!!  Well I think it is.....",
                wdu.getButtons().findElement("(//h4[@class='modal-title'])[2]").getAttribute("textContent"));

        WebElement closeButton = Browser.getBrowser().findElementByCssSelector("div#myModalJSClick>div>div>div:nth-of-type(3)>button");
        js.executeScript("arguments[0].click();", closeButton);
    }

    @Test
    public void actionClickTest(){

        scrollAndGoTo(wdu.getHomepage().getButtonsLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Lets Get Clicking!']")));

        Actions actions = new Actions(Browser.getBrowser());

        actions.moveToElement(wdu.getButtons().getButton3()).click().perform();

        Assert.assertEquals("Well done! the Action Move & Click can become very useful!",
                wdu.getButtons().findElement("(//h4[@class='modal-title'])[3]").getAttribute("textContent"));
        wait.until(ExpectedConditions.elementToBeClickable(wdu.getButtons().getCloseButton3()));
        actions.moveToElement(wdu.getButtons().getCloseButton3()).click().perform();
    }
}
