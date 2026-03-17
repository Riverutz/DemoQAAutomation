package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsFramesWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;

    public void navigateToAlertsFrameWindowsMenu() {
        elementsMethods.clickJSElement(alertsFramesWindowsMenu);
    }

    public void navigateToFormsMenu() {
        elementsMethods.clickJSElement(formsMenu);
    }

    public void navigateToElementsMenu() {
        elementsMethods.clickElement(elementsMenu);
    }
}
