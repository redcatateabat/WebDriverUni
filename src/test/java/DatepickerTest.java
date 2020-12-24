import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Assert.assertEquals(today.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")), getDateFieldValue());

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
    public void selectNextMonthDate(){

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));
        wdu.getDatepicker().getCalendarButton().click();

        wdu.getDatepicker().getForwardButton().click(); //go one month forward

        Month activeMonth = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).getMonth();
        boolean isItLeapYear = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).isLeapYear();

        Random r = new Random(); //click a random day
        int min = 1;
        int max = activeMonth.length(isItLeapYear)-1;
        int dateRange = r.nextInt(max-min) + min;
        String selectedDate = wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").getText();
        wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").click();

        wdu.getDatepicker().getCalendarButton().click(); //expand the calendar again to read the month value
        String selectedMonthYear = wdu.getDatepicker().getMonthUpButton().getText();

        String selectedDateComplete = selectedDate +" "+selectedMonthYear;
        LocalDate selectedDateFormatted = LocalDate.parse(selectedDateComplete, DateTimeFormatter.ofPattern("d MMMM yyyy"));

        wait.until(ExpectedConditions.attributeToBe(By.className("form-control"), "class", "form-control"));
        Assert.assertEquals(selectedDateFormatted.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")), getDateFieldValue());
        System.out.println("Selected date is "+ selectedDateComplete);


    }

    @Test
    public void selectRandomDates() {

        scrollAndGoTo(wdu.getHomepage().getDatepickerLink());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Datepicker']")));
        wdu.getDatepicker().getCalendarButton().click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@class='datepicker-switch']")));
        wdu.getDatepicker().getMonthUpButton().click(); //go to selection of months
        wdu.getDatepicker().getYearUpButton().click(); //go to selection of years

        Random r = new Random();
        int yearRange = r.nextInt(9-1)+1; //get random year
        String selectedYear = wdu.getDatepicker().findElement("(//span[@class=\"year\"])["+yearRange+"]").getText();
        wdu.getDatepicker().findElement("(//span[@class=\"year\"])["+yearRange+"]").click();

        int monthRange = r.nextInt(12-1) + 1; //get random month
        String selectedMonth = wdu.getDatepicker().findElement("(//span[@class=\"month\"])["+monthRange+"]").getText();
        wdu.getDatepicker().findElement("(//span[@class=\"month\"])["+monthRange+"]").click();

        Month activeMonth = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).getMonth();
        boolean isItLeapYear = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).isLeapYear();

        int min = 1; //get random day
        int max = activeMonth.length(isItLeapYear)-1;
        int dateRange = r.nextInt(max-min) + min;
        String selectedDate = wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").getText();
        wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").click();


        String selectedDateComplete = selectedDate +" "+selectedMonth+ " "+selectedYear;
        LocalDate selectedDateFormatted = LocalDate.parse(selectedDateComplete, DateTimeFormatter.ofPattern("d MMM yyyy"));
        Assert.assertEquals(selectedDateFormatted.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")), getDateFieldValue());
        System.out.println("Selected date is "+ selectedDateComplete);
    }
}
