package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormSubMenu;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@name='gender']")
    private List<WebElement> genders;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement dateOfBirthMonth;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement dateOfBirthYear;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') " + "and not(contains(@class,'--outside-month'))]")
    private List<WebElement> dateOfBirthDays;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@id,'hobbies-checkbox')]")
    private List<WebElement> hobbiesInput;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "react-select-3-input")
    private WebElement currentStateInput;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "react-select-4-input")
    private WebElement currentCityInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement modalForm;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;

    public void navigateToPracticeFormSubMenu() {
        elementsMethods.clickJSElement(practiceFormSubMenu);
    }

    public void fillTheEntireForm(String firstNameValue, String lastNameValue, String userEmailValue,
                                  String genderValue, String userNumberValue, String monthValue,
                                  String yearValue, String dayValue, String subjectsValue,
                                  List<String> hobbiesValues, String picturePathValue, String currentAddressValue,
                                  String currentStateValue, String currentCityValue) {

        elementsMethods.fillElement(firstName, firstNameValue);
        elementsMethods.fillElement(lastName, lastNameValue);
        elementsMethods.fillElement(userEmail, userEmailValue);

        switch (genderValue) {
            case "Male":
                elementsMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(0).getAttribute("id") + "']")));
                break;
            case "Female":
                elementsMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(1).getAttribute("id") + "']")));
                break;
            case "Other":
                elementsMethods.clickJSElement(driver.findElement(By.xpath("//label[@for='" + genders.get(2).getAttribute("id") + "']")));
                break;
        }

        elementsMethods.fillElement(userNumber, userNumberValue);

        elementsMethods.clickJSElement(dateOfBirthInput);
        elementsMethods.selectByTextElement(dateOfBirthMonth, monthValue);
        elementsMethods.scrollPage(0, 350);
        elementsMethods.selectByTextElement(dateOfBirthYear, yearValue);
        boolean dayFound = false;
        for (WebElement day : dateOfBirthDays) {
            if (day.getText().equals(dayValue)) {
                elementsMethods.clickElement(day);
                dayFound = true;
                break;
            }
        }
        if (!dayFound) {
            throw new RuntimeException("Day " + dayValue + " is not available for selected month/year.");
        }

        elementsMethods.fillElement(subjectsInput, subjectsValue);
        elementsMethods.pressElement(subjectsInput, Keys.ENTER);

        for (WebElement input : hobbiesInput) {
            String id = input.getAttribute("id");
            WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
            if (hobbiesValues.contains(label.getText().trim())) {
                if (!input.isSelected()) {
                    elementsMethods.clickJSElement(label);
                }
            }
        }

        File file = new File("src/test/resources/" + picturePathValue);
        uploadPicture.sendKeys(file.getAbsolutePath());

        elementsMethods.fillElement(currentAddress, currentAddressValue);

        elementsMethods.scrollPage(0, 350);
        elementsMethods.clickJSElement(state);
        elementsMethods.fillElement(currentStateInput, currentStateValue);
        elementsMethods.pressElement(currentStateInput, Keys.ENTER);

        elementsMethods.clickJSElement(city);
        elementsMethods.fillElement(currentCityInput, currentCityValue);
        elementsMethods.pressElement(currentCityInput, Keys.ENTER);

        elementsMethods.scrollPage(0, 350);
        elementsMethods.clickJSElement(submitButton);
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




