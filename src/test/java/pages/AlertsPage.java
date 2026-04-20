package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("AlertsPage initialized");
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private WebElement promtButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    public void clickAndAcceptAlert() {
        LoggerUtility.info("Clicking 'Alert' button");
        elementsMethods.clickElement(alertButton);

        LoggerUtility.info("Accepting alert");
        alertsMethods.acceptAlert();
    }

    public void clickAndDismissConfirm() {
        LoggerUtility.info("Clicking 'Confirm' button");
        elementsMethods.clickElement(confirmButton);

        LoggerUtility.info("Clicking 'OK' on confirm alert");
        alertsMethods.acceptAlert();
    }

    public void clickAndFillAlertPrompt() {
        LoggerUtility.info("Clicking 'Prompt' button");
        elementsMethods.clickElement(promtButton);

        LoggerUtility.info("Filling prompt alert with value: Daniel");
        alertsMethods.fillAlert("Daniel");
    }

    public void clickAndAcceptTimerAlert(){
        LoggerUtility.info("Clicking 'Timer Alert' button");
        elementsMethods.clickElement(timerAlertButton);

        LoggerUtility.info("Waiting for timer alert and accepting it");
        alertsMethods.acceptAlert();
    }
}
