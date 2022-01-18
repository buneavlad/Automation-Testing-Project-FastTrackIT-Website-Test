package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/shop")
public class ShopPage extends PageObject {
    @FindBy(css = "li[class*='post-']:nth-child(2)")
    private WebElementFacade product;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElementFacade addproduct;


    @FindBy(css = "div.woocommerce-message")
    private WebElementFacade addToCartMessage;


    public void clickProduct() {
        clickOn(product);
    }

    public void clickAddProduct() {
        clickOn(addproduct);
    }

    public String getCartMessage() {
        return addToCartMessage.getText();
    }


}
