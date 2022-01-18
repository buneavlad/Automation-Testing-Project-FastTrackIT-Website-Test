package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllPostsPage extends PageObject {

    @FindBy(css = "td.title.column-title.has-row-actions.column-primary.page-title > div.row-actions > span.trash > a")
    private WebElementFacade trashButton;

    @FindBy(css = "div[id=\"message\"]>p")
    private WebElementFacade removeMessage;

    public void clickTrashButton() {
        clickOn(trashButton);
    }

    public String getRemoveMessage() {
        return removeMessage.getText();
    }

    public void hoveroverPost() {
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.cssSelector("td[data-colname=\"Title\"]"));
        action.moveToElement(element).perform();
    }
}
