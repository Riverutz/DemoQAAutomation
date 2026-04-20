package pages;

import loggerutility.LoggerUtility;
import objectdata.WebTablesObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage {
    public WebTablesPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("WebTablesPage initialized");
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "salary")
    private WebElement salary;

    @FindBy(id = "department")
    private WebElement department;

    @FindBy(id = "edit-record-4")
    private WebElement editRecord4;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "delete-record-4")
    private WebElement deleteRecord4;

    public void addNewRecord() {
        elementsMethods.clickElement(addNewRecordButton);
    }

    public void addEntry(WebTablesObject testData) {
        LoggerUtility.info("Filling new record form");

        LoggerUtility.info("Entering first name: " + testData.getFirstNameValue());
        elementsMethods.fillElement(firstName, testData.getFirstNameValue());

        LoggerUtility.info("Entering last name: " + testData.getLastNameValue());
        elementsMethods.fillElement(lastName, testData.getLastNameValue());

        LoggerUtility.info("Entering email: " + testData.getUserEmailValue());
        elementsMethods.fillElement(userEmail, testData.getUserEmailValue());

        LoggerUtility.info("Entering age: " + testData.getAgeFieldValue());
        elementsMethods.fillElement(age, testData.getAgeFieldValue());

        LoggerUtility.info("Entering salary: " + testData.getSalaryFieldValue());
        elementsMethods.fillElement(salary, testData.getSalaryFieldValue());

        LoggerUtility.info("Entering department: " + testData.getDepartmentFieldValue());
        elementsMethods.fillElement(department, testData.getDepartmentFieldValue());

        LoggerUtility.info("Submitting new record");
        elementsMethods.clickElement(submitButton);
    }

    public void editEntry(WebTablesObject testData) {
        LoggerUtility.info("Clicking edit button for record 4");
        elementsMethods.clickJSElement(editRecord4);

        LoggerUtility.info("Scrolling to edit form");
        elementsMethods.scrollPage(0, 250);

        LoggerUtility.info("Updating salary: " + testData.getEditSalaryFieldValue());
        elementsMethods.clearFillElement(salary, testData.getEditSalaryFieldValue());

        LoggerUtility.info("Updating department: " + testData.getEditDepartmentFieldValue());
        elementsMethods.clearFillElement(department, testData.getEditDepartmentFieldValue());

        LoggerUtility.info("Submitting updated record");
        elementsMethods.clickElement(submitButton);
    }

    public void deleteEntry() {
        LoggerUtility.info("Deleting record 4");
        elementsMethods.clickElement(deleteRecord4);
    }
}
