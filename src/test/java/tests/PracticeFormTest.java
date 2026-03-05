package tests;

import helperMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void practiceFormTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickJSElement(formsMenu);

        WebElement practiceFormSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Practice Form']")));
        elementMethods.clickJSElement(practiceFormSubMenu);

        WebElement firstName = driver.findElement(By.id("firstName"));
        String firstNameValue = "Daniel";
        elementMethods.fillElement(firstName, firstNameValue);

        WebElement lastName = driver.findElement(By.id("lastName"));
        String lastNameValue = "Vlasceanu";
        elementMethods.fillElement(lastName, lastNameValue);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        String userEmailValue = "automationtesting@gmail.com";
        elementMethods.fillElement(userEmail, userEmailValue);

        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Male";
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

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        String userNumberValue = "0712412445";
        elementMethods.fillElement(userNumber, userNumberValue);

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        elementMethods.clickJSElement(dateOfBirth);

        WebElement dateOfBirthMonth = driver.findElement(By.className("react-datepicker__month-select"));
        elementMethods.selectByTextElement(dateOfBirthMonth, "December");

        /// Ensure year and day dropdowns are in view before selecting values
        /// This prevents potential visibility issues caused by fixed banners or ads

        elementMethods.scrollPage(0, 350);

        WebElement dateOfBirthYear = driver.findElement(By.className("react-datepicker__year-select"));
        elementMethods.selectByTextElement(dateOfBirthYear, "2000");

        List<WebElement> dateOfBirthDays = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day') " + "and not(contains(@class,'--outside-month'))]"));
        String dateOfBirthDaysValue = "23";
        boolean dayFound = false;
        for (WebElement day : dateOfBirthDays) {
            if (day.getText().equals(dateOfBirthDaysValue)) {
                elementMethods.clickElement(day);
                dayFound = true;
                break;
            }
        }
        if (!dayFound) {
            throw new RuntimeException("Day " + dateOfBirthDaysValue + " is not available for selected month/year.");
        }

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        String subjectsInputValue = "Arts";
        elementMethods.fillElement(subjects, subjectsInputValue);
        elementMethods.pressElement(subjects, Keys.ENTER);

        List<WebElement> hobbiesInputs = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'hobbies-checkbox')]"));
        List<String> hobbiesValues = Arrays.asList("Reading", "Music");
        for (WebElement input : hobbiesInputs) {
            String id = input.getAttribute("id");
            WebElement label = driver.findElement(By.xpath("//label[@for='" + id + "']"));
            if (hobbiesValues.contains(label.getText().trim())) {
                if (!input.isSelected()) {
                    elementMethods.clickJSElement(label);
                }
            }
        }

        WebElement fileUploadElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/exempluUpload.txt");
        fileUploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str. Carpati, Nr.24, Orasul Focsani, Jud. Vrancea, Cod Postal: 625100";
        elementMethods.fillElement(currentAddress, currentAddressValue);

        /// Ensure state and city dropdowns are in view before selecting values
        /// This prevents potential visibility issues caused by fixed banners or ads

        elementMethods.scrollPage(0, 350);

        WebElement currentState = driver.findElement(By.id("state"));
        elementMethods.clickJSElement(currentState);

        WebElement currentStateInput = driver.findElement(By.id("react-select-3-input"));
        String currentStateInputValue = "Haryana";
        elementMethods.fillElement(currentStateInput, currentStateInputValue);
        elementMethods.pressElement(currentStateInput, Keys.ENTER);

        WebElement currentCity = driver.findElement(By.id("city"));
        elementMethods.clickJSElement(currentCity);

        WebElement currentCityInput = driver.findElement(By.id("react-select-4-input"));
        String currentCityInputValue = "Karnal";
        elementMethods.fillElement(currentCityInput, currentCityInputValue);
        elementMethods.pressElement(currentCityInput, Keys.ENTER);

        /// Ensure the submit button is visible before clicking
        /// This prevents potential visibility issues caused by fixed banners or ads

        elementMethods.scrollPage(0, 350);

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementMethods.clickJSElement(submitButton);

        /// Verify that the confirmation modal appears and submitted form values are correct

        WebElement thankYouMessage = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessage.getText(), "Thanks for submitting the form");
        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + userEmailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + userNumberValue);
        String actualDate = tableValues.get(4).getText();
        String expectedDate = "Date of Birth 23 December,2000";
        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectsInputValue);
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + file.getName());
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + currentAddressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + currentStateInputValue + " " + currentCityInputValue);
    }
}
