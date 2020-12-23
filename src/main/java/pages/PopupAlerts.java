package pages;

import org.openqa.selenium.WebElement;

public class PopupAlerts extends BasePage {

    private String javaClickmeButton = "button1";
    private String javaCloseButton = "";
    private String modalClickmeButton = "button2";
    private String modalCloseButton = "//button[text()=\"Close\"]";
    private String confirmClickmeButton = "button4";
    private String okButton = "";
    private String cancelButton = "";
    private String messageText = "//p[@id=\"confirm-alert-text\"]";

    public WebElement getJavaClickmeButton(){ return findElement(javaClickmeButton);}
    public WebElement getJavaCloseButton(){ return findElement(javaCloseButton);}
    public WebElement getModalClickmeButton(){ return findElement(modalClickmeButton);}
    public WebElement getModalCloseButton(){ return findElement(modalCloseButton);}
    public WebElement getConfirmClickmeButton(){ return findElement(confirmClickmeButton);}
    public WebElement getOkButton(){ return findElement(okButton);}
    public WebElement getCancelButton(){ return findElement(cancelButton);}
    public WebElement getMessageText(){ return findElement(messageText);}
}
