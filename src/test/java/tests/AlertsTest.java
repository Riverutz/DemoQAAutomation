package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void alertsTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertsFramesWindowsMenu);

        WebElement alertsSubMenu = elementMethods.waitForElementVisibleByXpath("//span[text()='Alerts']", 10);
        elementMethods.clickElement(alertsSubMenu);

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(alertButton);
        alertMethods.acceptAlert();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(confirmButton);
        alertMethods.dismissAlert();

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(promtButton);
        alertMethods.fillAlert("Daniel");

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(timerAlertButton);
        alertMethods.acceptAlert();
    }
}
