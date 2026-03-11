package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "edit-record-4")
    public WebElement editRecord4;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "delete-record-4")
    public WebElement deleteRecord4;

    public void addNewRecord() {
        elementMethods.clickElement(addNewRecordButton);
    }

    public void addEntry(String firstNameValue, String lastNameValue, String userEmailValue,
                         String ageFieldValue, String salaryFieldValue, String departmentFieldValue) {
        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.fillElement(userEmail, userEmailValue);
        elementMethods.fillElement(age, ageFieldValue);
        elementMethods.fillElement(salary, salaryFieldValue);
        elementMethods.fillElement(department, departmentFieldValue);
        elementMethods.clickElement(submitButton);
    }

    public void editEntry(String editSalaryFieldValue, String editDepartmentFieldValue) {
        elementMethods.clickJSElement(editRecord4);
        elementMethods.scrollPage(0, 250);
        elementMethods.clearFillElement(salary, editSalaryFieldValue);
        elementMethods.clearFillElement(department, editDepartmentFieldValue);
        elementMethods.clickElement(submitButton);
    }

    public void deleteEntry() {
        elementMethods.clickElement(deleteRecord4);
        windowMethods.quitPage();
    }
}
