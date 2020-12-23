package pages;

import org.openqa.selenium.WebElement;

public class DropCheckRadio extends BasePage {

    private String dropdMenu1 = "//select[@id=\"dropdowm-menu-1\"]/*";
    private String dropdMenu2 = "//select[@id=\"dropdowm-menu-2\"]/*";
    private String dropdMenu3 = "//select[@id=\"dropdowm-menu-3\"]/*";
    private String checkboxes = "//div[@id=\"checkboxes\"]/label/input";
    private String radioButtons = "//form[@id=\"radio-buttons\"]/input";
    private String radioButtonsDisabled = "//form[@id=\"radio-buttons-selected-disabled\"]/input";
    private String dropdMenuDisabled = "//select[@id=\"fruit-selects\"]/option";

    public WebElement getDropdMenu1(){ return findElement(dropdMenu1);}
    public WebElement getDropdMenu2(){ return findElement(dropdMenu2);}
    public WebElement getDropdMenu3(){ return findElement(dropdMenu3);}
    public WebElement getCheckboxes(){ return findElement(checkboxes);}
    public WebElement getRadioButtons(){ return findElement(radioButtons);}
    public WebElement getRadioButtonsDisabled(){ return findElement(radioButtonsDisabled);}
    public WebElement getDropdMenuDisabled(){ return findElement(dropdMenuDisabled);}
}
