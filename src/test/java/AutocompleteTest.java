import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutocompleteTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void positiveFlowTest() {

        scrollAndGoTo(wdu.getHomepage().getAutocompleteLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Food Item']")));


        ArrayList<String> firstChars = new ArrayList<>(Arrays.asList("A", "B", "C"));
        for (int i = 0; i<firstChars.size(); i++){

            wdu.getAutocomplete().getFoodField().sendKeys(firstChars.get(i));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/strong")));
            ArrayList<String> suggestedList = new ArrayList<>();
            List<WebElement> listItems = Browser.getBrowser().findElements(By.xpath("//div/strong"));
            for (WebElement item : listItems) {
                String suggestion = item.getText();
                suggestedList.add(suggestion);
            }

            Assert.assertEquals(suggestedList.get(i), firstChars.get(i));

            wdu.getAutocomplete().getFoodField().clear();

        }
    }
}
