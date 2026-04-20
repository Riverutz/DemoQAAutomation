package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindowsPage extends BasePage{
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("AlertsWindowsPage initialized");
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubMenu;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubMenu;

    public void navigateToBrowserWindowsSubMenu() {
        LoggerUtility.info("Clicking 'Browser Windows' submenu");
        elementsMethods.clickJSElement(browserWindowsSubMenu);
    }

    public void navigateToFramesSubMenu() {
        LoggerUtility.info("Clicking 'Frames' submenu");
        elementsMethods.clickJSElement(framesSubMenu);
    }

    public void navigateToAlertsSubMenu(){
        LoggerUtility.info("Clicking 'Alerts' submenu");
        elementsMethods.clickElement(alertsSubMenu);
    }
}
