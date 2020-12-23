package pages;

import org.openqa.selenium.WebElement;

public class Datepicker extends BasePage {

    private String calendarButton = "//i[@class='glyphicon glyphicon-calendar']";
    private String thisDay = "//td[@class='today day']";
    private String forwardButton = "(//th[@class='next'])[1]";
    private String monthUpButton = "(//th[@class=\"datepicker-switch\"])[1]";
    private String thisMonth = "//span[@class='month active']";
    private String yearUpButton = "(//th[@class=\"datepicker-switch\"])[2]";
    private String thisYear = "//span[@class='year active']";

    public WebElement getCalendarButton(){ return findElement(calendarButton);}
    public WebElement getThisDay(){ return findElement(thisDay);}
    public WebElement getForwardButton(){ return findElement(forwardButton);}
    public WebElement getMonthUpButton(){ return findElement(monthUpButton);}
    public WebElement getThisMonth(){ return findElement(thisMonth);}
    public WebElement getYearUpButton(){ return findElement(yearUpButton);}
    public WebElement getThisYear(){ return findElement(thisYear);}

}
