package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("HomePage initialized");
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFramesWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public void navigateToAlertsFrameWindowsMenu() {
        LoggerUtility.info("Clicking 'Alerts, Frame & Windows' menu");
        elementsMethods.clickJSElement(alertsFramesWindowsMenu);
    }

    public void navigateToFormsMenu() {
        LoggerUtility.info("Clicking 'Forms' menu");
        elementsMethods.clickJSElement(formsMenu);
    }

    public void navigateToElementsMenu() {
        LoggerUtility.info("Clicking 'Elements' menu");
        elementsMethods.clickElement(elementsMenu);
    }
}
