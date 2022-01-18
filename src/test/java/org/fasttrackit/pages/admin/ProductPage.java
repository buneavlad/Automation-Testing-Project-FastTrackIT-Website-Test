package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ProductPage extends PageObject {


    @FindBy(id = "title")
    private WebElementFacade addTitle;


    @FindBy(id = "content")
    private WebElementFacade addContent;

    @FindBy(css = "input[name=\"_regular_price\"]")
    private WebElementFacade addPrice;

    @FindBy(id = "publish")
    private WebElementFacade publishButton;

    @FindBy(id = "message")
    private WebElementFacade productMessage;

    @FindBy(css = "a[class=\"wp-first-item current\"]")
    private WebElementFacade allProducts;

    @FindBy(css = "a[class=\"submitdelete\"]")
    private WebElementFacade moveToTrashProduct;

    @FindBy(css = "#message > p")
    private WebElementFacade removeProductMesage;


    public void addTitle(String name) {
        typeInto(addTitle, name);
    }

    public void addContent(String text) {
        typeInto(addContent, text);
    }

    public void setPrice(String price) {
        typeInto(addPrice, price);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,-250)", "");

    }

    public void clickPublishButton() {
        publishButton.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable();
        clickOn(publishButton);
    }

    public String checkProductMessage() {
        return productMessage.getText();
    }

    public void clickAllProducts() {
        clickOn(allProducts);
    }

    public void hoveroverAddedProduct() {
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.cssSelector("a[class=\"row-title\"]"));
        action.moveToElement(element).perform();

    }

    public void clickTrashButton() {
        clickOn(moveToTrashProduct);
    }

    public String removeProductMessage() {
        return removeProductMesage.getText();
    }


}
