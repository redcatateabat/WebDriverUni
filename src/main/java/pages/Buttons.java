package pages;

import org.openqa.selenium.WebElement;

public class Buttons extends BasePage {

    private String button1 = "//span[@id='button1']//p[1]";
    private String button2 = "(//span[@type='button'])[2]";
    private String button3 = "(//span[@type='button'])[3]";
    private String closeButton1 = "(//button[text()=\"Close\"])[1]";
    private String closeButton2 = "(//button[text()=\"Close\"])[2]";
    private String closeButton3 = "(//button[@class='btn btn-default'])[3]";

    public WebElement getButton1(){ return findElement(button1);}
    public WebElement getButton2(){ return findElement(button2);}
    public WebElement getButton3(){ return findElement(button3);}
    public WebElement getCloseButton1(){ return findElement(closeButton1);}
    public WebElement getCloseButton2(){ return findElement(closeButton2);}
    public WebElement getCloseButton3(){ return findElement(closeButton3);}
}
