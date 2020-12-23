package pages;

import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {

    private String contactLink = "(//div[@class=\"section-title\"])[1]";
    private String loginLink = "//h1[text()='LOGIN PORTAL']";
    private String buttonsLink = "//h1[text()='BUTTON CLICKS']";
    private String todoLink = "//h1[text()='TO DO LIST']";
    private String accordionLink = "//h4[text()='Click on one of the accordion panels! Do you see any text?']/following-sibling::p";
    private String dropCheckRadioLink = "//h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']";
    private String ajaxLink = "//h1[text()='AJAX LOADER']";
    private String actionsLink = "//h1[text()='ACTIONS']";
    private String autocompleteLink = "//h1[text()='AUTOCOMPLETE TEXTFIELD']";
    private String datepickerLink = "//h1[text()='DATEPICKER']";
    private String popupAlertsLink = "//h1[text()='POPUP & ALERTS']";
    private String scrollLink = "//h1[text()='SCROLLING AROUND']";


    public WebElement getContactLink(){ return findElement(contactLink);}
    public WebElement getLoginLink(){ return  findElement(loginLink);}
    public WebElement getButtonsLink(){ return findElement(buttonsLink);}
    public WebElement getTodoLink(){ return  findElement(todoLink);}
    public WebElement getAccordionLink(){ return findElement(accordionLink);}
    public WebElement getDropCheckRadioLink(){ return findElement(dropCheckRadioLink);}
    public WebElement getAjaxLink(){return findElement(ajaxLink);}
    public WebElement getActionsLink(){ return findElement(actionsLink);}
    public WebElement getAutocompleteLink(){ return findElement(autocompleteLink);}
    public WebElement getDatepickerLink(){ return findElement(datepickerLink);}
    public WebElement getPopupAlertsLink(){ return findElement(popupAlertsLink);}
    public WebElement getScrollLink(){ return findElement(scrollLink);}

}
