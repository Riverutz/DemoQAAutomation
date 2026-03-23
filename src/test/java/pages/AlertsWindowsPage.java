package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindowsPage extends BasePage{
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubMenu;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubMenu;

    public void navigateToBrowserWindowsSubMenu() {
        elementsMethods.clickJSElement(browserWindowsSubMenu);
    }

    public void navigateToFramesSubMenu() {
        elementsMethods.clickJSElement(framesSubMenu);
    }

    public void navigateToAlertsSubMenu(){
        elementsMethods.clickElement(alertsSubMenu);
    }
}
