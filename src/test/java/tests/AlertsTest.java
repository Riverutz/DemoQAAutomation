package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void alertsTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToAlertsSubMenu();

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAndAcceptAlert();
        alertsPage.clickAndDismissConfirm();
        alertsPage.clickAndFillAlertPrompt();
        alertsPage.clickAndAcceptTimerAlert();
    }
}
