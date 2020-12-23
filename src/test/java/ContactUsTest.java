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

import java.util.ArrayList;
import java.util.List;

public class ContactUsTest extends BaseTest{

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);


    @Test
    public void positiveFlowTest() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id=\"contact-us\"]")));

        scrollAndGoTo(wdu.getHomepage().getContactLink());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='feedback-input'])[1]")));
        wdu.getContact().getFirstNameField().sendKeys("Pera");
        wdu.getContact().getLastNameField().sendKeys("Peric");
        wdu.getContact().getEmailField().sendKeys("pera@peric.com");
        wdu.getContact().getCommentsField().sendKeys("Hi");
        wdu.getContact().getSubmitButton().click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id=\"contact_reply\"]"), "Thank You for your Message!"));
        Assert.assertEquals("Thank You for your Message!", wdu.getContact().findElement("//div[@id=\"contact_reply\"]").getText());


    }

    @Test
    public void leaveFieldsBlankTest(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id=\"contact-us\"]")));

        scrollAndGoTo(wdu.getHomepage().getContactLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='feedback-input'])[1]")));
        wdu.getContact().getSubmitButton().click();
        wait.until(ExpectedConditions.titleIs("Contact form handler"));
        Assert.assertEquals(
                "Error: all fields are required"
                        +"\n" +
                        "Error: Invalid email address",
                wdu.getContact().findElement("//body").getText());
    }

    @Test
    public void resetButtonTest(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id=\"contact-us\"]")));

        scrollAndGoTo(wdu.getHomepage().getContactLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='feedback-input'])[1]")));

        wdu.getContact().getFirstNameField().sendKeys("Pera");
        String firstNameInput = wdu.getContact().getFirstNameField().getAttribute("value");
        wdu.getContact().getLastNameField().sendKeys("Peric");
        String lastNameInput = wdu.getContact().getLastNameField().getAttribute("value");
        wdu.getContact().getEmailField().sendKeys("pera@peric.com");
        String emailInput = wdu.getContact().getEmailField().getAttribute("value");
        wdu.getContact().getCommentsField().sendKeys("Hi");
        String commentInput = wdu.getContact().getCommentsField().getAttribute("value");

        wdu.getContact().getResetButton().click();
        String firstNameReset = wdu.getContact().getFirstNameField().getAttribute("value");
        String lastNameReset = wdu.getContact().getLastNameField().getAttribute("value");
        String emailReset = wdu.getContact().getEmailField().getAttribute("value");
        String commentReset = wdu.getContact().getCommentsField().getAttribute("value");

        Assert.assertNotEquals(firstNameInput + lastNameInput +
                emailInput + commentInput, firstNameReset + lastNameReset +
                emailReset + commentReset);

        Assert.assertEquals(firstNameReset + lastNameReset +
                emailReset + commentReset, "");

    }
}
