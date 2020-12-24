import browser.Browser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Wdu;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestClass {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test

    public void test1() throws InterruptedException {

        Browser.getBrowser().manage().window().maximize();
        Browser.getBrowser().get("http://webdriveruniversity.com/Datepicker/index.html");

        wdu.getDatepicker().getCalendarButton().click();
        Month selectedMonth = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).getMonth();
        boolean isItLeapYear = YearMonth.parse(wdu.getDatepicker().getMonthUpButton().getText(), DateTimeFormatter.ofPattern("MMMM yyyy")).isLeapYear();
        int monthLenght = selectedMonth.length(isItLeapYear);

        Random r = new Random();
        int min = 1;
        int max = monthLenght-1;
        int dateRange = r.nextInt(max-min) + min;
        String selectedDate = wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").getText();
        wdu.getDatepicker().findElement("(//tbody/tr/td)["+dateRange+"]").click();
        wdu.getDatepicker().getCalendarButton().click();

        String selectedMonthYear = wdu.getDatepicker().getMonthUpButton().getText();

        System.out.println("Selected date is "+ selectedDate +" "+selectedMonthYear);

    }
    }

