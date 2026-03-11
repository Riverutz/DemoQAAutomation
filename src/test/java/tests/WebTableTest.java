package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void webTableTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

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
