package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage{
    public WebTablesPage(WebDriver driver) {
        super(driver);
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
        windowsMethods.quitPage();
    }
}
