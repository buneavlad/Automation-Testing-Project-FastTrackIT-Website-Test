package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")
public class LoginPage extends PageObject {
    @FindBy(id = "username")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(css = "button[name='login']")
    private WebElementFacade loginButton;

    @FindBy(css = "div > p:nth-child(1)")
    private WebElementFacade getWelcomeMessage;

    @FindBy(css = "#post-13 li")
    private WebElementFacade errorInvalidPassword;

    @FindBy(css = "p.woocommerce-LostPassword.lost_password > a")
    private WebElementFacade lostPasswordLink;

    @FindBy(css = "input[name=\"user_login\"]")
    private WebElementFacade emailOrUsernameRecoveryField;

    @FindBy(css = "button[value=\"Reset password\"]")
    private WebElementFacade resetPasswordButton;

    @FindBy(css = "div.woocommerce-message")
    private WebElementFacade resetPasswordMessage;


    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void setLoginButton() {
        clickOn(loginButton);

    }

    public String welcomeMessage() {
        return getWelcomeMessage.getText();

    }

    public String errorMessage() {
        return errorInvalidPassword.getText();
    }

    public void clickLostPassword() {
        clickOn(lostPasswordLink);
    }

    public void setEmailOrUsernameRecoveryField(String user) {
        typeInto(emailOrUsernameRecoveryField, user);
    }

    public void clickResetPassword() {
        clickOn(resetPasswordButton);
    }

    public String resetMesasge() {
        return resetPasswordMessage.getText();
    }
}

