package tests;

import objectdata.PracticeFormObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.BaseTest;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        PracticeFormObject testData = new PracticeFormObject("testdata/PracticeFormData.json");
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.navigateToPracticeFormSubMenu();
        practiceFormPage.fillTheEntireForm(testData);
        practiceFormPage.verifyFormSubmission(testData);
    }
}
