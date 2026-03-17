package tests;

import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramesPage;
import pages.HomePage;
import pages.NestedFramesPage;
import sharedData.SharedData;

public class FramesTest extends SharedData {

    @Test
    public void frameTest() {
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
