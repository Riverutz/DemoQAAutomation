package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;

    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTablesSubMenu;

    public void navigateToWebTablesSubMenu() {
        elementMethods.clickJSElement(webTablesSubMenu);
    }
}
