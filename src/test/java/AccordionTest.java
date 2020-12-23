import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.Wdu;

public class AccordionTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);


    @Test
    public void positiveFlow() {

        scrollAndGoTo(wdu.getHomepage().getAccordionLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));

        wdu.getAccordion().getAcc1().click();
        wait.until(ExpectedConditions.attributeToBe(By.id("manual-testing-accordion"), "class", "accordion active"));

        boolean text1 = isAccordionOpen("//button[@id=\"manual-testing-accordion\"]");
        Assert.assertTrue(text1);

        wdu.getAccordion().getAcc1().click();
        wait.until(ExpectedConditions.attributeToBe(By.id("manual-testing-accordion"), "class", "accordion"));
        boolean text2 = isAccordionOpen("//button[@id=\"manual-testing-accordion\"]");
        Assert.assertFalse(text2);

        wdu.getAccordion().getAcc2().click();
        wait.until(ExpectedConditions.attributeToBe(By.id("cucumber-accordion"), "class", "accordion active"));

        wdu.getAccordion().getAcc3().click();

        wait.until(ExpectedConditions.textToBePresentInElement(wdu.getAccordion().getLoadMsg(), "LOADING COMPLETE."));
        wdu.getAccordion().getAcc5Sec().click();
        wait.until(ExpectedConditions.attributeToBe(By.id("click-accordion"), "class", "accordion active"));
        Assert.assertEquals("This text has appeared after 5 seconds!", wdu.getAccordion().findElement("(//div[@class='panel'])[4]").getText());

    }

    @Test
    public void noTimeout(){

        scrollAndGoTo(wdu.getHomepage().getAccordionLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-header")));
        wdu.getAccordion().getAcc5Sec().click();

        boolean text1 = isAccordionOpen("(//div[@class='panel'])[4]");
        Assert.assertFalse(text1);

    }
}
