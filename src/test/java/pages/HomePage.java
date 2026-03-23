package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFramesWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

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
