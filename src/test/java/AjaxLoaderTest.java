import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

public class AjaxLoaderTest extends BaseTest{

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void waitTest(){

        scrollAndGoTo(wdu.getHomepage().getAjaxLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id=\"button1\"]")));
        wait.until(ExpectedConditions.elementToBeClickable(wdu.getAjaxLoader().getClickMeButton()));
        wdu.getAjaxLoader().getClickMeButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(wdu.getAjaxLoader().getPopUpAlert()));
        Assert.assertEquals("Well Done For Waiting....!!!", wdu.getAjaxLoader().findElement("//div[@class='modal-header']//h4[1]").getText());

        wdu.getAjaxLoader().getPopUpAlert().click();
    }
}
