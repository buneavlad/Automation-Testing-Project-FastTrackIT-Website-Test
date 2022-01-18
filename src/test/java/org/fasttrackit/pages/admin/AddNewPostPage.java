package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddNewPostPage extends PageObject {

    @FindBy(css = "a[href=\"post-new.php\"]")
    private WebElementFacade addNew;

    @FindBy(id = "title")
    private WebElementFacade postTitle;

    @FindBy(css = "textarea[name=\"content\"]")
    private WebElementFacade content;

    @FindBy(css = "div[id=\"publishing-action\"]>input[type=\"submit\"]")
    private WebElementFacade publishButton;

    @FindBy(css = "div[id=\"message\"]>p")
    private WebElementFacade publishMessage;

    public void clickAddNew() {
        clickOn(addNew);
    }

    public void setTitle(String title) {
        typeInto(postTitle, title);
    }

    public void setContent(String text) {
        typeInto(content, text);
    }

    public void clickPublishButton() {
        clickOn(publishButton);
    }

    public String getPublishMessage() {
        return publishMessage.getText();
    }


}
