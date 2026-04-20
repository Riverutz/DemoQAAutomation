package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("WindowsPage initialized");
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    public void openNewTab() {
        LoggerUtility.info("Clicking 'New Tab' button");
        elementsMethods.clickJSElement(newTabButton);

        LoggerUtility.info("Current URL (main tab): " + driver.getCurrentUrl());

        LoggerUtility.info("Switching to new tab");
        windowsMethods.switchSpecificTab(1);

        LoggerUtility.info("Current URL (new tab): " + driver.getCurrentUrl());

        LoggerUtility.info("Closing new tab");
        windowsMethods.closeCurrentTab();

        LoggerUtility.info("Switching back to main tab");
        windowsMethods.switchSpecificTab(0);
    }

    public void openNewWindow() {
        LoggerUtility.info("Clicking 'New Window' button");
        elementsMethods.clickJSElement(newWindowButton);

        LoggerUtility.info("Current URL (main window): " + driver.getCurrentUrl());

        LoggerUtility.info("Switching to new window");
        windowsMethods.switchSpecificTab(1);

        LoggerUtility.info("Current URL (new window): " + driver.getCurrentUrl());

        LoggerUtility.info("Closing new window");
        windowsMethods.closeCurrentTab();
    }
}
