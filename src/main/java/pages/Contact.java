package pages;

import org.openqa.selenium.WebElement;

public class Contact extends BasePage {

    private String firstNameField = "(//input[@class='feedback-input'])[1]";
    private String lastNameField = "//input[@placeholder='Last Name']";
    private String emailField = "//input[@placeholder='Email Address']";
    private String commentsField = "//textarea[@placeholder='Comments']";
    private String resetButton = "//input[@type='reset']";
    private String submitButton = "//input[@type='submit']";

    public WebElement getFirstNameField(){ return findElement(firstNameField);}
    public WebElement getLastNameField(){ return findElement(lastNameField);}
    public WebElement getEmailField(){ return findElement(emailField);}
    public WebElement getCommentsField(){ return findElement(commentsField);}
    public WebElement getResetButton(){ return findElement(resetButton);}
    public WebElement getSubmitButton(){ return findElement(submitButton);}
}
