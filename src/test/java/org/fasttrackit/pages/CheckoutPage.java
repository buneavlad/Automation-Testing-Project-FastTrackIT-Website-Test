package org.fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://qa3.fasttrackit.org:8008/checkout")

public class CheckoutPage extends PageObject {
    @FindBy(css = "input[name=\"billing_first_name\"]")
    private WebElementFacade firstNameField;

    @FindBy(css = "input[name=\"billing_last_name\"]")
    private WebElementFacade lastNameField;

    @FindBy(css = "input[name=\"billing_address_1\"]")
    private WebElementFacade streetAdressField;

    @FindBy(css = "input[name=\"billing_city\"]")
    private WebElementFacade townField;

    @FindBy(css = "input[name=\"billing_postcode\"]")
    private WebElementFacade postCodeField;

    @FindBy(css = "input[name=\"billing_phone\"]")
    private WebElementFacade phoneField;

    @FindBy(css = "input[name=\"billing_email\"]")
    private WebElementFacade emailField;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "div p:first-child")
    private WebElementFacade receivedOrderMessage;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElementFacade invalidEmailMessage;


    public void setFirstNameField(String firstname) {
        typeInto(firstNameField, firstname);
    }

    public void setLastNameField(String lastname) {
        typeInto(lastNameField, lastname);
    }

    public void setStreetAdressField(String adress) {
        typeInto(streetAdressField, adress);
    }

    public void setTownField(String town) {
        typeInto(townField, town);
    }

    public void setPostCodeField(String postcode) {
        typeInto(postCodeField, postcode);
    }

    public void setPhoneField(String phone) {
        typeInto(phoneField, phone);
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);

    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);

    }

    public void waitAfterButton() {
        placeOrderButton.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilNotVisible();

    }

    public String getReceivedOrderMessage() {
        return receivedOrderMessage.getText();

    }

    public String getInvalidEmailMessage() {
        return invalidEmailMessage.getText();
    }


}
