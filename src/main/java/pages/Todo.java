package pages;

import org.openqa.selenium.WebElement;

public class Todo extends BasePage {

    private String itemAddField = "//input[@type=\"text\"]";
    private String itemFields = "//ul/li";
    private String itemDeleteButtons = "fa fa-trash";
    private String itemAddButton = "plus-icon";

    public WebElement getItemAddField(){ return findElement(itemAddField);}
    public WebElement getItemFields(){ return findElement(itemFields);}
    public WebElement getItemDeleteButtons(){ return findElement(itemDeleteButtons);}
    public WebElement getItemAddButton(){ return findElement(itemAddButton);}
}
