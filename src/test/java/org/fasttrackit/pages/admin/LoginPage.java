package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/admin")

public class LoginPage extends PageObject {
    @FindBy(id = "user_login")
    private WebElementFacade userField;
    @FindBy(id = "user_pass")
    private WebElementFacade passwordField;
    @FindBy(css = "input[type=\"submit\"]")
    private WebElementFacade loginButton;

    public void setUserField(String username) {
        typeInto(userField, username);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);

    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }
}
