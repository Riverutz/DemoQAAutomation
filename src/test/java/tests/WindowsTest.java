package tests;

import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;
import sharedData.SharedData;

public class WindowsTest extends SharedData {

    @Test
    public void windowTest() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToBrowserWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.openNewTab();
        windowsPage.openNewWindow();
    }
}
