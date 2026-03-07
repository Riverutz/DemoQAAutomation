package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    public void openNewTab() {
        elementMethods.clickJSElement(newTabButton);
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }

    public void openNewWindow() {
        elementMethods.clickJSElement(newWindowButton);
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.quitPage();
    }
}
