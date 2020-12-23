package pages;

import org.openqa.selenium.WebElement;

public class Scroll extends BasePage {

    private String topFrame = "//div[@id=\"zone1\"]";
    private String leftFrame = "//div[@id=\"zone2\"]";
    private String rightFrame = "//div[@id=\"zone3\"]";
    private String bottomFrame = "//div[@id=\"zone4\"]";

    public WebElement getTopFrame(){ return findElement(topFrame);}
    public WebElement getLeftFrame(){ return findElement(leftFrame);}
    public WebElement getRightFrame(){ return findElement(rightFrame);}
    public WebElement getBottomFrame(){ return findElement(bottomFrame);}
}
