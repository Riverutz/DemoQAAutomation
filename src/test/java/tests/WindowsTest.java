package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;

public class WindowsTest {
    public WebDriver driver;

    @Test
    public void windowTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToBrowserWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.openNewTab();
        windowsPage.openNewWindow();
    }
}
