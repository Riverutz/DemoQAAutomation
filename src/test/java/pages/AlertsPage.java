package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "promtButton")
    public WebElement promtButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    public void clickAndAcceptAlert() {
        elementsMethods.clickElement(alertButton);
        alertsMethods.acceptAlert();
    }

    public void clickAndDismissConfirm() {
        elementsMethods.clickElement(confirmButton);
        alertsMethods.dismissAlert();
    }

    public void clickAndFillAlertPrompt() {
        elementsMethods.clickElement(promtButton);
        alertsMethods.fillAlert("Daniel");
    }

    public void clickAndAcceptTimerAlert(){
        elementsMethods.clickElement(timerAlertButton);
        alertsMethods.acceptAlert();
    }
}
