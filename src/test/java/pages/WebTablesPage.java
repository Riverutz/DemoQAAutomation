package pages;

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

    public void addEntry(String firstNameValue, String lastNameValue, String userEmailValue,
                         String ageFieldValue, String salaryFieldValue, String departmentFieldValue) {
        elementsMethods.fillElement(firstName, firstNameValue);
        elementsMethods.fillElement(lastName, lastNameValue);
        elementsMethods.fillElement(userEmail, userEmailValue);
        elementsMethods.fillElement(age, ageFieldValue);
        elementsMethods.fillElement(salary, salaryFieldValue);
        elementsMethods.fillElement(department, departmentFieldValue);
        elementsMethods.clickElement(submitButton);
    }

    public void editEntry(String editSalaryFieldValue, String editDepartmentFieldValue) {
        elementsMethods.clickJSElement(editRecord4);
        elementsMethods.scrollPage(0, 250);
        elementsMethods.clearFillElement(salary, editSalaryFieldValue);
        elementsMethods.clearFillElement(department, editDepartmentFieldValue);
        elementsMethods.clickElement(submitButton);
    }

    public void deleteEntry() {
        elementsMethods.clickElement(deleteRecord4);
    }
}
