package tests;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void windowTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WindowMethods windowMethods = new WindowMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement alertFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowsMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickJSElement(browserWindowsSubMenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementMethods.clickJSElement(newTabButton);

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();

        windowMethods.switchSpecificTab(0);
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        elementMethods.clickJSElement(newWindowButton);

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        windowMethods.quitPage();
    }
}
