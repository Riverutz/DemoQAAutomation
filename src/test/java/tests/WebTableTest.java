package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void webTableTest() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navigateToWebTablesSubMenu();

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.addNewRecord();
        webTablesPage.addEntry("Daniel", "Vlasceanu", "autotesting@gmail.com",
                "35", "3500", "Testing");
        webTablesPage.editEntry("7500", "Programming");
        webTablesPage.deleteEntry();
    }
}
