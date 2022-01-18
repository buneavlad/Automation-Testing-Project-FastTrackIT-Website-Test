package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CouponPage extends PageObject {

    @FindBy(css = "div.wrap>a")
    private WebElementFacade addCouponButton;

    @FindBy(id = "title")
    private WebElementFacade couponTitle;

    @FindBy(id = "coupon_amount")
    private WebElementFacade couponAmount;

    @FindBy(css = "#publishing-action>input[type=\"submit\"]")
    private WebElementFacade publishButton;

    @FindBy(css = "#message>p")
    private WebElementFacade couponMessage;


    public void clickAddCouponButton() {
        clickOn(addCouponButton);

    }

    public void setTitle(String title) {
        typeInto(couponTitle, title);
    }

    public void setCouponAmount(String amount) {
        typeInto(couponAmount, amount);
    }

    public void clickPublishButton() {
        clickOn(publishButton);
    }

    public String getCouponMessage() {
        return couponMessage.getText();
    }
}
