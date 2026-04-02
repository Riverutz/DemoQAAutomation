package pages;

import objectdata.WebTablesObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage {
    public WebTablesPage(WebDriver driver) {
        super(driver);
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
        elementsMethods.fillElement(firstName, testData.getFirstNameValue());
        elementsMethods.fillElement(lastName, testData.getLastNameValue());
        elementsMethods.fillElement(userEmail, testData.getUserEmailValue());
        elementsMethods.fillElement(age, testData.getAgeFieldValue());
        elementsMethods.fillElement(salary, testData.getSalaryFieldValue());
        elementsMethods.fillElement(department, testData.getDepartmentFieldValue());
        elementsMethods.clickElement(submitButton);
    }

    public void editEntry(WebTablesObject testData) {
        elementsMethods.clickJSElement(editRecord4);
        elementsMethods.scrollPage(0, 250);
        elementsMethods.clearFillElement(salary, testData.getEditSalaryFieldValue());
        elementsMethods.clearFillElement(department, testData.getEditDepartmentFieldValue());
        elementsMethods.clickElement(submitButton);
    }

    public void deleteEntry() {
        elementsMethods.clickElement(deleteRecord4);
    }
}
