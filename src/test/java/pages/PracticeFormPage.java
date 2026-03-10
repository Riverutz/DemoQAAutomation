package pages;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.File;
import java.util.List;

public class PracticeFormPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormSubMenu;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(xpath = "//input[@name='gender']")
    public List<WebElement> genders;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement dateOfBirthMonth;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement dateOfBirthYear;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') " + "and not(contains(@class,'--outside-month'))]")
    public List<WebElement> dateOfBirthDays;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@id,'hobbies-checkbox')]")
    public List<WebElement> hobbiesInput;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "react-select-3-input")
    public WebElement currentStateInput;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "react-select-4-input")
    public WebElement currentCityInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement modalForm;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    public List<WebElement> tableValues;

    public void navigateToPracticeFormSubMenu() {
        elementMethods.clickJSElement(practiceFormSubMenu);
    }

    public void fillTheEntireForm(String firstNameValue, String lastNameValue, String userEmailValue,
                                  String genderValue, String userNumberValue, String monthValue,
                                  String yearValue, String dayValue, String subjectsValue,
                                  List<String> hobbiesValues, String picturePathValue, String currentAddressValue,
                                  String currentStateValue, String currentCityValue) {

        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.fillElement(userEmail, userEmailValue);

        switch (genderValue) {
            case "Male":
                elementMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(0).getAttribute("id") + "']")));
                break;
            case "Female":
                elementMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(1).getAttribute("id") + "']")));
                break;
            case "Other":
                elementMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(2).getAttribute("id") + "']")));
                break;
        }

        elementMethods.fillElement(userNumber, userNumberValue);

        elementMethods.clickJSElement(dateOfBirthInput);
        elementMethods.selectByTextElement(dateOfBirthMonth, monthValue);
        elementMethods.scrollPage(0, 350);
        elementMethods.selectByTextElement(dateOfBirthYear, yearValue);
        boolean dayFound = false;
        for (WebElement day : dateOfBirthDays) {
            if (day.getText().equals(dayValue)) {
                elementMethods.clickElement(day);
                dayFound = true;
                break;
            }
        }
        if (!dayFound) {
            throw new RuntimeException("Day " + dayValue + " is not available for selected month/year.");
        }

        elementMethods.fillElement(subjectsInput, subjectsValue);
        elementMethods.pressElement(subjectsInput, Keys.ENTER);

        for (WebElement input : hobbiesInput) {
            String id = input.getAttribute("id");
            WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
            if (hobbiesValues.contains(label.getText().trim())) {
                if (!input.isSelected()) {
                    elementMethods.clickJSElement(label);
                }
            }
        }

        File file = new File("src/test/resources/exempluUpload.txt");
        uploadPicture.sendKeys(file.getAbsolutePath());

        elementMethods.fillElement(currentAddress, currentAddressValue);

        elementMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(state);
        elementMethods.fillElement(currentStateInput, currentStateValue);
        elementMethods.pressElement(currentStateInput, Keys.ENTER);

        elementMethods.clickJSElement(city);
        elementMethods.fillElement(currentCityInput, currentCityValue);
        elementMethods.pressElement(currentCityInput, Keys.ENTER);

        elementMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(submitButton);
    }

    public void verifyFormSubmission(String firstNameValue, String lastNameValue, String userEmailValue, String genderValue,
                                     String userNumberValue, String monthValue, String yearValue, String dayValue,
                                     String subjectsInputValue, List<String> hobbiesValues, String picturePathValue,
                                     String currentAddressValue, String currentStateInputValue, String currentCityInputValue) {
        Assert.assertEquals(modalForm.getText(), "Thanks for submitting the form");
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + userEmailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + userNumberValue);
        String actualDate = tableValues.get(4).getText();
        String expectedDate = "Date of Birth " + dayValue + " " + monthValue + "," + yearValue;
        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectsInputValue);
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + currentAddressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + currentStateInputValue + " " + currentCityInputValue);
    }
}




