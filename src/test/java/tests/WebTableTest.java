package tests;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void webTableTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        WindowMethods windowMethods = new WindowMethods(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickElement(elementsMenu);

        WebElement webTablesSubMenu = elementMethods.waitForElementVisibleByXpath("//span[text()='Web Tables']", 10);
        elementMethods.clickJSElement(webTablesSubMenu);

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addButton);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Daniel";
        elementMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Vlasceanu";
        elementMethods.fillElement(lastNameField, lastNameValue);

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        String userEmailValue = "autotesting@gmail.com";
        elementMethods.fillElement(userEmailField, userEmailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageFieldValue = "35";
        elementMethods.fillElement(ageField, ageFieldValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryFieldValue = "5500";
        elementMethods.fillElement(salaryField, salaryFieldValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentFieldValue = "Testing";
        elementMethods.fillElement(departmentField, departmentFieldValue);

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitButton);

        WebElement editRecord4 = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJSElement(editRecord4);

        ///Scrolled to make edit fields visible
        /// This prevents potential visibility issues caused by fixed banners or ads

        elementMethods.scrollPage(0, 250);

        WebElement editSalaryField = driver.findElement(By.id("salary"));
        String editSalaryFieldValue = "4500";
        elementMethods.clearFillElement(editSalaryField, editSalaryFieldValue);

        WebElement editDepartmentField = driver.findElement(By.id("department"));
        String editDepartmentFieldValue = "Programming";
        elementMethods.clearFillElement(editDepartmentField, editDepartmentFieldValue);

        WebElement editSubmitButton = driver.findElement(By.id("submit"));
        elementMethods.clickElement(editSubmitButton);

        WebElement deleteRecord4 = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickElement(deleteRecord4);

        windowMethods.quitPage();
    }
}
