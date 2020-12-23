package pages;

import org.openqa.selenium.WebElement;

public class AjaxLoader extends BasePage {

    private String clickMeButton = "//span[@id=\"button1\"]";
    private String popUpAlert = "//button[@class='btn btn-default']";

    public WebElement getClickMeButton(){ return findElement(clickMeButton);}
    public WebElement getPopUpAlert(){ return findElement(popUpAlert);}
}
