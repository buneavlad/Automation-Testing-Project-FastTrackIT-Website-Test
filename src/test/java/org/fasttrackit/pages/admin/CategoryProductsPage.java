package org.fasttrackit.pages.admin;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CategoryProductsPage extends PageObject {

    @FindBy(id = "tag-name")
    private WebElementFacade nameField;

    @FindBy(id = "tag-description")
    private WebElementFacade descriptionField;

    @FindBy(id = "submit")
    private WebElementFacade addNewCategoryButton;

    @FindBy(css = "#the-list>tr")
    private List<WebElementFacade> categoryList;


    public void setNameField(String name) {
        typeInto(nameField, name);

    }

    public void setDescriptionField(String text) {
        typeInto(descriptionField, text);
    }

    public void clickAddNewCategoryButton() {
        clickOn(addNewCategoryButton);
    }

    public boolean checkIfCategoryIsAdded(String getCategory) {
        for (WebElementFacade elementFacade : categoryList) {
            String category = elementFacade.findElement(By.cssSelector("a[class=\"row-title\"]")).getText();
            if (getCategory.contains(category)) {
                System.out.println(getCategory);

                return true;

            }
        }
        return false;
    }


}
