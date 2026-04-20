package tests;

import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;
import sharedData.BaseTest;

public class WindowsTest extends BaseTest {

    @Test
    public void windowTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToBrowserWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.openNewTab();
        windowsPage.openNewWindow();
    }
}
