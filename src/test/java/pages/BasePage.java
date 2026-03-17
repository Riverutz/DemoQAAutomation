package pages;

import helperMethods.AlertsMethods;
import helperMethods.ElementsMethods;
import helperMethods.FramesMethods;
import helperMethods.WindowsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public AlertsMethods alertsMethods;
    public ElementsMethods elementsMethods;
    public FramesMethods framesMethods;
    public WindowsMethods windowsMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        alertsMethods = new AlertsMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
