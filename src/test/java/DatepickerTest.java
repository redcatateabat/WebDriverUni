import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatepickerTest extends BaseTest {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test
    public void showCurrentDate() {

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));

        LocalDate today = LocalDate.now();

        wait.until(ExpectedConditions.attributeToBe(By.className("form-control"), "class", "form-control"));
        String currentDate = Browser.getBrowser().findElementByClassName("form-control").getAttribute("value");
        DateTimeFormatter completeDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        Assert.assertEquals(today.format(completeDate), currentDate);

        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd");
        wdu.getDatepicker().getCalendarButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='today day']")));

        String doubleDigitDate = "";
        if (wdu.getDatepicker().getThisDay().getText().length()<2){
            doubleDigitDate = "0"+wdu.getDatepicker().getThisDay().getText();
        }
        else doubleDigitDate = wdu.getDatepicker().getThisDay().getText();

        Assert.assertEquals(doubleDigitDate,today.format(day));

        String monthName = "";
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
        String monthNumber = today.format(month);
        switch(monthNumber){
            case "01": monthName = "Jan";
            break;
            case "02": monthName = "Feb";
            break;
            case "03" : monthName = "Mar";
            break;
            case "04" : monthName = "Apr";
            break;
            case "05" : monthName = "May";
            break;
            case "06" : monthName = "Jun";
            break;
            case "07" : monthName = "Jul";
            break;
            case "08" : monthName = "Aug";
            break;
            case "09" : monthName = "Sep";
            break;
            case "10" : monthName = "Oct";
            break;
            case "11" : monthName = "Nov";
            break;
            case "12" : monthName = "Dec";
            break;

        }

        wdu.getDatepicker().getMonthUpButton().click();
        Assert.assertEquals(monthName, wdu.getDatepicker().getThisMonth().getText());

        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        wdu.getDatepicker().getYearUpButton().click();
        Assert.assertEquals(today.format(year), wdu.getDatepicker().getThisYear().getText() );

        System.out.println("Current date is"
                + ": "+ today.format(day)+ "/" + monthName+ "/" + today.format(year));
    }

    /*@Test
    public void selectDate(){

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));

        

    }*/
}
