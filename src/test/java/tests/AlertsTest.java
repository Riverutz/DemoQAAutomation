package tests;

import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test
    public void alertsTest() {
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
