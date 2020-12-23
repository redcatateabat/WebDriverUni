package pages;

import org.openqa.selenium.WebElement;

public class Autocomplete extends BasePage {

    private String foodField = "//input[@placeholder='Food Item']";
    private String submitButton = "//input[@type='submit']";
    private String suggestionList = "//input[@type=\"hidden\"]";

    public WebElement getFoodField(){ return findElement(foodField);}
    public WebElement getSubmitButton(){ return findElement(submitButton);}
    public WebElement getSuggestionList(){ return findElement(suggestionList);}
}
