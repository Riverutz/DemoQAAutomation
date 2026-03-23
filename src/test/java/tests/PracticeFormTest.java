package tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void practiceFormTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        String firstNameValue = "Daniel";
        String lastNameValue = "Vlasceanu";
        String userEmailValue = "automationtesting@gmail.com";
        String genderValue = "Male";
        String userNumberValue = "0712412445";
        String monthValue = "December";
        String yearValue = "2000";
        String dayValue = "23";
        String subjectsValue = "Arts";
        List<String> hobbiesValues = Arrays.asList("Reading", "Music");
        String picturePathValue = "exempluUpload.txt";
        String currentAddressValue = "Str. Carpati, Nr.24, Orasul Focsani, Jud. Vrancea, Cod Postal: 625100";
        String currentStateValue = "Haryana";
        String currentCityValue = "Karnal";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.navigateToPracticeFormSubMenu();
        practiceFormPage.fillTheEntireForm(firstNameValue, lastNameValue, userEmailValue, genderValue,
                userNumberValue, monthValue, yearValue, dayValue, subjectsValue, hobbiesValues,
                picturePathValue, currentAddressValue, currentStateValue, currentCityValue);

        practiceFormPage.verifyFormSubmission(firstNameValue, lastNameValue, userEmailValue, genderValue,
                userNumberValue, monthValue, yearValue, dayValue, subjectsValue, hobbiesValues,
                picturePathValue, currentAddressValue, currentStateValue, currentCityValue);
    }
}
