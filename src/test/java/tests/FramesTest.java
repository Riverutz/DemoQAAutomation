package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramesPage;
import pages.HomePage;
import pages.NestedFramesPage;

public class FramesTest {
    public WebDriver driver;

    @Test
    public void frameTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.readLargeFrameHeading();
        framesPage.readSmallFrameHeading();
        framesPage.navigateToNestedFramesSubMenu();

        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        nestedFramesPage.navigateToChildFrame();
    }
}
