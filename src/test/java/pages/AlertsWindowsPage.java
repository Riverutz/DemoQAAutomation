package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public AlertsWindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubMenu;

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesSubMenu;

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubMenu;

    public void navigateToBrowserWindowsSubMenu() {
        elementMethods.clickJSElement(browserWindowsSubMenu);
    }

    public void navigateToFramesSubMenu() {
        elementMethods.clickJSElement(framesSubMenu);
    }

    public void navigateToAlertsSubMenu(){
        elementMethods.clickElement(alertsSubMenu);
    }
}
