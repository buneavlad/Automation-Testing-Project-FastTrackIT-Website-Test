package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends PageObject {
    @FindBy(css = "main>article>div:nth-child(2)")
    private List<WebElementFacade> products;


    public boolean getProductName(String getname) {
        for (WebElementFacade elementFacade : products) {
            String name = elementFacade.findElement(By.cssSelector(".entry-title a")).getText();
            if (name.contentEquals(getname)) {
                return true;


            }
        }
        return false;

    }


}
