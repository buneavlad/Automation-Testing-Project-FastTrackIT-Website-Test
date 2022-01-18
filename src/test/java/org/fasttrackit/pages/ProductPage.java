package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ProductPage extends PageObject {
    @FindBy(css = "a[class=\"star-5\"]")
    private WebElementFacade starsReview;

    @FindBy(css = "textarea[name=\"comment\"]")
    private WebElementFacade commentReview;

    @FindBy(id = "author")
    private WebElementFacade nameOfReviewer;

    @FindBy(id = "email")
    private WebElementFacade emailofReviewer;

    @FindBy(id = "submit")
    private WebElementFacade submitButton;

    @FindBy(css = "div[class=\"comment-text\"]")
    private List<WebElementFacade> commentList;

    @FindBy(css = "a[aria-label*=\"Add “aaa” to your cart\"]")
    private WebElementFacade addAAAtoCart;

    @FindBy(css = "a[aria-label*=\"Add “abc” to your cart\"]")
    private WebElementFacade addABCtoCart;


    public void addStarToReview() {
        clickOn(starsReview);
    }

    public void addCommenttoReview(String text) {
        typeInto(commentReview, text);

    }

    public void setNameOfReviewer(String name) {
        typeInto(nameOfReviewer, name);
    }

    public void setEmailofReviewer(String email) {
        typeInto(emailofReviewer, email);
    }

    public void clickSubmitButton() {
        clickOn(submitButton);
    }


    public boolean getCommentOfReview(String getComment) {
        for (WebElementFacade elementFacade : commentList) {
            String comment = elementFacade.findElement(By.cssSelector(".description>p")).getText();
            if (getComment.contains(comment)) {
                return true;
            }
        }
        return false;
    }


    public void addAaaToCart() {
        clickOn(addAAAtoCart);
    }

    public void addAbcToCart() {
        clickOn(addABCtoCart);
    }


}
