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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestClass {

    Wdu wdu = new Wdu();
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 15);

    @Test

    public void test1() {

        Browser.getBrowser().manage().window().maximize();
        Browser.getBrowser().get("http://webdriveruniversity.com/Datepicker/index.html");

        String currentDate = Browser.getBrowser().findElementByClassName("form-control").getAttribute("value");
        System.out.println(currentDate);
    }
    }

