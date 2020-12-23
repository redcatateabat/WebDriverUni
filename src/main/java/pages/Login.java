package pages;

import org.openqa.selenium.WebElement;

public class Login extends BasePage {

    private String usernameField = "//input[@id=\"text\"]";
    private String passwordField = "//input[@id=\"password\"]";
    private String loginButton = "//button[text()='Login']";

    public WebElement getUsernameField(){ return findElement(usernameField);}
    public WebElement getPasswordField(){ return findElement(passwordField);}
    public WebElement getLoginButton(){ return findElement(loginButton);}

}
