package pages;

import javax.swing.*;

public class Wdu {

private Accordion accordion;
private Actions actions;
private AjaxLoader ajaxLoader;
private Autocomplete autocomplete;
private Buttons buttons;
private Contact contact;
private Datepicker datepicker;
private DropCheckRadio dropCheckRadio;
private Login login;
private PopupAlerts popupAlerts;
private Scroll scroll;
private Todo todo;
private Homepage homepage;

    public Accordion getAccordion() {
    if (accordion == null) {
        accordion = new Accordion();
    }
    return accordion;
}

    public Actions getActions() {
    if (actions == null) {
        actions = new Actions();
    }
        return actions;
    }

    public AjaxLoader getAjaxLoader() {
    if (ajaxLoader == null){
        ajaxLoader = new AjaxLoader();
    }
        return ajaxLoader;
    }

    public Autocomplete getAutocomplete() {
        if (autocomplete == null){
            autocomplete = new Autocomplete();
        }
        return autocomplete;
    }

    public Buttons getButtons() {
        if (buttons == null){
            buttons = new Buttons();
        }
        return buttons;
    }

    public Contact getContact() {
        if (contact == null){
            contact = new Contact();
        }
        return contact;
    }

    public Datepicker getDatepicker() {
        if (datepicker == null){
            datepicker = new Datepicker();
        }
        return datepicker;
    }

    public DropCheckRadio getDropCheckRadio() {
        if (dropCheckRadio == null){
            dropCheckRadio = new DropCheckRadio();
        }
        return dropCheckRadio;
    }

    public Login getLogin() {
        if (login == null){
            login = new Login();
        }
        return login;
    }

    public PopupAlerts getPopupAlerts() {
        if (popupAlerts == null){
            popupAlerts = new PopupAlerts();
        }
        return popupAlerts;
    }

    public Scroll getScroll() {
        if (scroll == null){
            scroll = new Scroll();
        }
        return scroll;
    }

    public Todo getTodo() {
        if (todo == null){
            todo = new Todo();
        }
        return todo;
    }

    public Homepage getHomepage() {
        if (homepage == null){
            homepage = new Homepage();
        }
        return homepage;
    }
}
