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
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsFrameWindowsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToFramesSubMenu();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.readLargeFrameHeading();
        framesPage.readSmallFrameHeading();
        framesPage.navigateToNestedFramesSubMenu();

        NestedFramesPage nestedFramesPage = new NestedFramesPage(getDriver());
        nestedFramesPage.navigateToChildFrame();
    }
}
