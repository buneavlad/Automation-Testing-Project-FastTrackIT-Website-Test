package org.fasttrackit.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")
public class RegisterPage extends PageObject {
    @FindBy(id="reg_email")
    private WebElementFacade emailField;

    @FindBy(id="reg_password")
    private WebElementFacade passwordField;

    @FindBy(css="button[name='register']")
    private WebElementFacade registerButton;

    @FindBy(css="#post-13 p:first-child")
    private WebElementFacade getWelcomeMessage;


    public void setEmailField (String email){
        typeInto(emailField,email);
    }
    public void setPasswordField(String password){
        typeInto(passwordField,password);
    }
    public void clickRegister(){
        registerButton.click();
    }

    public String welcomeMessage(){
        return getWelcomeMessage.getText();

    }



}
