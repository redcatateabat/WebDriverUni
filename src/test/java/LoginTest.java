import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

public class LoginTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void negativeFlowTest() throws InterruptedException {

        scrollAndGoTo(wdu.getHomepage().getLoginLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"text\"]")));

        wdu.getLogin().getUsernameField().sendKeys("User");
        wdu.getLogin().getPasswordField().sendKeys("1234");
        wdu.getLogin().getLoginButton().click();
        Browser.getBrowser().switchTo().alert().accept();
        Thread.sleep(300);

        String url = Browser.getBrowser().getCurrentUrl();
        Assert.assertEquals("http://webdriveruniversity.com/Login-Portal/fail.html", url);


    }
}
