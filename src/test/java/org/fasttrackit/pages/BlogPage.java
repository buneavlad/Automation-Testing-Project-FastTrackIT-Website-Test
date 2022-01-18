package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/blog")
public class BlogPage extends PageObject {
    @FindBy(css = "textarea[id=\"comment\"]")
    private WebElementFacade commentsField;

    @FindBy(css = "input[id=\"author\"]")
    private WebElementFacade nameField;

    @FindBy(css = "input[id=\"email\"]")
    private WebElementFacade emailField;

    @FindBy(id = "submit")
    private WebElementFacade clickPostComment;

    @FindBy(css = "li article")
    private List<WebElementFacade> commentsLists;

    @FindBy(css = "#error-page > p:nth-child(2)")
    private WebElementFacade errorNameAndEmailField;

    @FindBy(css = "body p:nth-child(2)")
    private WebElementFacade errorCommentField;

    public void setCommentsFieldField(String comment) {
        typeInto(commentsField, comment);

    }

    public void setNameField(String name) {
        typeInto(nameField, name);
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void clickPostCommentButton() {
        waitABit(4000);
        clickOn(clickPostComment);
    }


    public boolean getNameOfCommentator(String getname) {
        for (WebElementFacade elementFacade : commentsLists) {
            String name = elementFacade.findElement(By.cssSelector("b[class=\"fn\"]")).getText();
            if (getname.contains(name)) {
                return true;
            }

        }
        return false;
    }

    public String nameAndEmailFieldError() {
        return errorNameAndEmailField.getText();
    }

    public String commentFieldError() {
        return errorCommentField.getText();
    }


    public boolean getComment(String getComment) {
        for (WebElementFacade elementFacade : commentsLists) {
            String name = elementFacade.findElement(By.cssSelector(".comment-content>p")).getText();
            if (getComment.contains(name)) {
                System.out.println(getComment);
                return true;

            }

        }
        return false;
    }
}


