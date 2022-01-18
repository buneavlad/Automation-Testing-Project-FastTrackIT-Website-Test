package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")

public class Homepage extends PageObject {
    @FindBy(css = "a[title=\"Login\"]")
    private WebElementFacade signinRegisterButton;

    @FindBy(css = "#menu-item-1643 > a")
    private WebElementFacade blogButton;

    @FindBy(css = "#menu-item-1728 a")
    private WebElementFacade shopButton;

    @FindBy(css = "span.header-cart-checkout > i")
    private WebElementFacade cartButton;

    @FindBy(css = "#menu-item-1729 a")
    private WebElementFacade checkoutButton;

    @FindBy(css = "i.fa.fa-search.search-btn")
    private WebElementFacade searchButton;

    @FindBy(css = "form>label>input")
    private WebElementFacade searchField;

    @FindBy(css = "input[class=\"search-submit\"]")
    private WebElementFacade searchFieldButton;

    public void signInRegisterButton() {
        clickOn(signinRegisterButton);
    }

    public void clickBlogButton() {
        clickOn(blogButton);
    }

    public void clickshopButton() {
        clickOn(shopButton);
    }

    public void clickCartButton() {
        clickOn(cartButton);
    }

    public void clickCheckoutButton() {
        clickOn(checkoutButton);
    }

    public void clickSearchButton() {
        clickOn(searchButton);
    }

    public void setSearchField(String name) {
        typeInto(searchField, name);
    }

    public void clickSearchFieldButton() {
        clickOn(searchFieldButton);
    }


}
