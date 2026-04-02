package tests;

import objectdata.WebTablesObject;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void webTableTest() {
        WebTablesObject testData = new WebTablesObject("testdata/WebTablesData.json");
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.navigateToWebTablesSubMenu();

        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.addNewRecord();
        webTablesPage.addEntry(testData);
        webTablesPage.editEntry(testData);
        webTablesPage.deleteEntry();
    }
}
