package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrdersPage extends PageObject {

    @FindBy(id = "post-search-input")
    private WebElementFacade searchField;

    @FindBy(id = "search-submit")
    private WebElementFacade searchOrders;

    @FindBy(css = "a[class=\"order-view\"]>strong")
    private WebElementFacade numberOfOrder;


    public void typeIntoSearchField(String search) {
        typeInto(searchField, search);
    }

    public void clickSearchOrders() {
        clickOn(searchOrders);
    }

    public String getNumberOfOrder() {
        return numberOfOrder.getText();
    }
}
