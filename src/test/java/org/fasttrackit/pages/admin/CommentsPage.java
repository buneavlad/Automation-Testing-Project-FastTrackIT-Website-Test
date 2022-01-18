package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommentsPage extends PageObject {


    @FindBy(css = ".approve>a")
    private WebElementFacade approveButton;

    @FindBy(css = ".response-links>a:nth-child(2)")
    private WebElementFacade viewPage;

    @FindBy(css = ".row-actions>.trash>a")
    private WebElementFacade trashButton;

    @FindBy(css = "div[class=\"trash-undo-inside\"]")
    private WebElementFacade trashMessage;


    public void hoveroverComment() {
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.cssSelector("td[class=\"author column-author\"]"));
        action.moveToElement(element).perform();
    }

    public void clickApproveButton() {
        waitFor(5000);
        clickOn(approveButton);
    }

    public void clickViewPage() {
        clickOn(viewPage);
    }

    public void clickTrashButton() {
        clickOn(trashButton);
    }

    public String getTrashMessage() {
        waitFor(5000);
        return trashMessage.getText();
    }


}
