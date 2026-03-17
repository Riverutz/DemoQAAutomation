package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    public void openNewTab() {
        elementsMethods.clickJSElement(newTabButton);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.closeCurrentTab();
        windowsMethods.switchSpecificTab(0);
    }

    public void openNewWindow() {
        elementsMethods.clickJSElement(newWindowButton);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.closeCurrentTab();
        windowsMethods.quitPage();
    }
}
