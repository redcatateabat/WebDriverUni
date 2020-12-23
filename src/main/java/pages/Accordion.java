package pages;

import org.openqa.selenium.WebElement;

public class Accordion extends BasePage {

private String acc1 = "//button[text()='Manual Testing']";
private String acc2 = "//button[text()='Cucumber BDD']";
private String acc3 = "//button[text()='Automation Testing']";
private String acc5Sec = "//button[text()='Keep Clicking! - Text will Appear After 5 Seconds!']";
private String loadMsg = "//p[@id=\"hidden-text\"]";

public WebElement getAcc1(){ return findElement(acc1); }
public WebElement getAcc2(){ return findElement(acc2); }
public WebElement getAcc3(){ return findElement(acc3); }
public WebElement getAcc5Sec(){ return findElement(acc5Sec);}
public WebElement getLoadMsg(){ return findElement(loadMsg);}

}
