import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatepickerTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void showCurrentDate() {

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));

        LocalDate today = LocalDate.now();

        //-----GET FULL VALUE FROM THE FIELD
        wait.until(ExpectedConditions.attributeToBe(By.className("form-control"), "class", "form-control"));
        String currentDateFromDropdown = Browser.getBrowser().findElementByClassName("form-control").getAttribute("value");
        Assert.assertEquals(today.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")), currentDateFromDropdown);

        //-----READ VALUE FROM BUTTONS
        DateTimeFormatter day = DateTimeFormatter.ofPattern("d");
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");

        wdu.getDatepicker().getCalendarButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='today day']")));

        String dateFromDropdown = wdu.getDatepicker().getThisDay().getText();
        Assert.assertEquals(dateFromDropdown,today.format(day));


        String monthName = today.format(month);
        wdu.getDatepicker().getMonthUpButton().click();
        Assert.assertEquals(monthName, wdu.getDatepicker().getThisMonth().getText());


        wdu.getDatepicker().getYearUpButton().click();
        Assert.assertEquals(today.format(year), wdu.getDatepicker().getThisYear().getText() );

        System.out.println("Current date is"
                + ": "+ today.format(day)+ "/" + monthName+ "/" + today.format(year));
    }

    @Test
    public void selectDate(){

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));
        wdu.getDatepicker().getCalendarButton().click();

        wdu.getDatepicker().getForwardButton().click(); //go one month forward




    }
}
