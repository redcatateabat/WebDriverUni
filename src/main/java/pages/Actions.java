package pages;

import org.openqa.selenium.WebElement;

public class Actions extends BasePage {

    private String dragBox = "//div[@id=\"draggable\"]";
    private String dropHereBox = "//div[@id='droppable']//p[1]";
    private String doubleClick = "//div[@id=\"double-click\"]";
    private String hover1 = "//div[@style=\"float:left;\"]";
    private String hover2 = "//div[@style=\"float:center;\"]";
    private String hover3 = "//div[@style=\"float:right;\"]";
    private String clickHold = "//div[@id=\"click-box\"]";
    private String link1 = "(//a[text()=\"Link 1\"])[1]";
    private String link2 = "(//a[text()=\"Link 1\"])[2]";
    private String link3 = "(//a[text()=\"Link 1\"])[3]";
    private String link4 = "(//a[text()=\"Link 1\"])[4]";
    private String alertCloseButton = "";

    public WebElement getDragBox(){ return findElement(dragBox);}
    public WebElement getDoubleClick(){ return findElement(doubleClick);}
    public WebElement getHover1(){ return findElement(hover1);}
    public WebElement getHover2(){ return findElement(hover2);}
    public WebElement getHover3(){ return findElement(hover3);}
    public WebElement getClickHold(){ return findElement(clickHold);}
    public WebElement getlink1(){ return findElement(link1);}
    public WebElement getlink2(){ return findElement(link2);}
    public WebElement getlink3(){ return findElement(link3);}
    public WebElement getlink4(){ return findElement(link4);}
    public WebElement getalertCloseButton(){ return findElement(alertCloseButton);}
    public WebElement getDropHereBox(){ return findElement(dropHereBox);}

}
