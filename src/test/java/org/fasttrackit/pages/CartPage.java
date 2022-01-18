package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/cart")
public class CartPage extends PageObject {
    @FindBy(css = "td[class=\"product-remove\"]")
    private WebElementFacade removeProduct;

    @FindBy(css = "div.entry-content > div.woocommerce-message")
    private WebElementFacade removeMessage;

    @FindBy(css = "input[type=\"number\"]")
    private WebElementFacade quantityfield;

    @FindBy(css = "div.woocommerce-message")
    private WebElementFacade quantityUpdateMessage;

    @FindBy(css = "button[value=\"Update cart\"]")
    private WebElementFacade updatebutton;

    @FindBy(css = "td> div>input[class=\"input-text\"]")
    private WebElementFacade cuponField;

    @FindBy(css = "input[class=\"button\"]")
    private WebElementFacade applyCuponButton;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElementFacade errorCuponMessage;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade cuponMessage;

    @FindBy(css = "tr[class=\"woocommerce-cart-form__cart-item cart_item\"]")
    private List<WebElementFacade> listCartProducts;

    @FindBy(css = "tr.cart-subtotal > td > span")
    private WebElementFacade subtotal;

    public void removeProductFromCart() {
        clickOn(removeProduct);
    }

    public String removeMess() {
        return removeMessage.getText();
    }

    public void changeQuantityField(String number) {
        typeInto(quantityfield, number);
    }

    public String quantityMessage() {
        return quantityUpdateMessage.getText();
    }

    public void clickUpdateButton() {
        clickOn(updatebutton);
    }

    public boolean tryToClickUpdateButton() {
        try {
            if (updatebutton.isEnabled()) {
                updatebutton.click();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Element is disabled");
        }
        return true;
    }

    public void setCuponField(String cupon) {
        typeInto(cuponField, cupon);
    }

    public void clickApplyCupon() {
        clickOn(applyCuponButton);
    }

    public String errorCuponMessage() {
        return errorCuponMessage.getText();
    }

    public String succesufullyCuponMessage() {
        return cuponMessage.getText();
    }


    public boolean sumOfProducts() {
        waitFor(5000);
        String firstPrice = listCartProducts.get(0).
                findElement(By.cssSelector("td.product-subtotal>span[class=\"woocommerce-Price-amount amount\"]")).
                getText().replace(",00 lei", "");
        int first = Integer.parseInt(firstPrice);

        String secondPrice = listCartProducts.get(1).
                findElement(By.cssSelector("td.product-subtotal>span[class=\"woocommerce-Price-amount amount\"]")).
                getText().replace(",00 lei", "");
        int second = Integer.parseInt(secondPrice);

        String subtotalSum = subtotal.getText().replace(",00 lei", "");
        int subtot = Integer.parseInt(subtotalSum);

        int sum = first + second;
        System.out.println(subtot);
        if (sum == subtot) {
            return true;

        }
        return false;
    }


}
