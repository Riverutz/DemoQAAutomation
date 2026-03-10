package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsFramesWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    public void navigateToAlertsFrameWindowsMenu() {
        elementMethods.clickJSElement(alertsFramesWindowsMenu);
    }

    public void navigateToFormsMenu() {
        elementMethods.clickJSElement(formsMenu);
    }
}
