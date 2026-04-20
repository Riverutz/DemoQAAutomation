package pages;

import loggerutility.LoggerUtility;
import objectdata.PracticeFormObject;
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
        LoggerUtility.info("PracticeFormPage initialized");
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
        LoggerUtility.info("Clicking 'Practice Form' submenu");
        elementsMethods.clickJSElement(practiceFormSubMenu);
    }

    public void fillTheEntireForm(PracticeFormObject testData) {
        LoggerUtility.info("Filling Practice Form");

        LoggerUtility.info("Entering first name: " + testData.getFirstNameValue());
        elementsMethods.fillElement(firstName, testData.getFirstNameValue());

        LoggerUtility.info("Entering last name: " + testData.getLastNameValue());
        elementsMethods.fillElement(lastName, testData.getLastNameValue());

        LoggerUtility.info("Entering email: " + testData.getUserEmailValue());
        elementsMethods.fillElement(userEmail, testData.getUserEmailValue());

        LoggerUtility.info("Selecting gender: " + testData.getGenderValue());
        switch (testData.getGenderValue()) {
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

        LoggerUtility.info("Entering mobile number: " + testData.getUserNumberValue());
        elementsMethods.fillElement(userNumber, testData.getUserNumberValue());
        LoggerUtility.info("Setting date of birth: " + testData.getDayValue() + " " + testData.getMonthValue() + " " + testData.getYearValue());
        elementsMethods.clickJSElement(dateOfBirthInput);

        elementsMethods.selectByTextElement(dateOfBirthMonth, testData.getMonthValue());
        elementsMethods.scrollPage(0, 350);
        elementsMethods.selectByTextElement(dateOfBirthYear, testData.getYearValue());

        boolean dayFound = false;
        for (WebElement day : dateOfBirthDays) {
            if (day.getText().equals(testData.getDayValue())) {
                elementsMethods.clickElement(day);
                dayFound = true;
                break;
            }
        }
        if (!dayFound) {
            throw new RuntimeException("Day " + testData.getDayValue() + " is not available for selected month/year.");
        }

        LoggerUtility.info("Entering subject: " + testData.getSubjectsValue());
        elementsMethods.fillElement(subjectsInput, testData.getSubjectsValue());
        elementsMethods.pressElement(subjectsInput, Keys.ENTER);

        for (WebElement input : hobbiesInput) {
            String id = input.getAttribute("id");
            WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
            if (testData.getHobbiesValues().contains(label.getText().trim())) {
                if (!input.isSelected()) {
                    elementsMethods.clickJSElement(label);
                }
            }
        }

        LoggerUtility.info("Uploading picture: " + testData.getPicturePathValue());
        File file = new File("src/test/resources/" + testData.getPicturePathValue());
        uploadPicture.sendKeys(file.getAbsolutePath());

        LoggerUtility.info("Entering current address");
        elementsMethods.fillElement(currentAddress, testData.getCurrentAddressValue());

        LoggerUtility.info("Selecting state: " + testData.getCurrentStateValue());
        elementsMethods.scrollPage(0, 350);
        elementsMethods.clickJSElement(state);
        elementsMethods.fillElement(currentStateInput, testData.getCurrentStateValue());
        elementsMethods.pressElement(currentStateInput, Keys.ENTER);

        LoggerUtility.info("Selecting city: " + testData.getCurrentCityValue());
        elementsMethods.clickJSElement(city);
        elementsMethods.fillElement(currentCityInput, testData.getCurrentCityValue());
        elementsMethods.pressElement(currentCityInput, Keys.ENTER);

        LoggerUtility.info("Submitting form");
        elementsMethods.scrollPage(0, 350);
        elementsMethods.clickJSElement(submitButton);
    }

    public void verifyFormSubmission(PracticeFormObject testData) {
        LoggerUtility.info("Verifying form submission modal");
        Assert.assertEquals(modalForm.getText(), "Thanks for submitting the form");
        LoggerUtility.info("Verifying submitted table values");
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + testData.getFirstNameValue() + " " + testData.getLastNameValue());
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + testData.getUserEmailValue());
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + testData.getGenderValue());
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + testData.getUserNumberValue());
        String actualDate = tableValues.get(4).getText();
        String expectedDate = "Date of Birth " + testData.getDayValue() + " " + testData.getMonthValue() + "," + testData.getYearValue();
        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + testData.getSubjectsValue());
        String expectedHobbiesText = "Hobbies " + String.join(", ", testData.getHobbiesValues());
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + testData.getPicturePathValue());
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + testData.getCurrentAddressValue());
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + testData.getCurrentStateValue() + " " + testData.getCurrentCityValue());
    }
}




