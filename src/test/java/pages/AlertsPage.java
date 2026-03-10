package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;
    public AlertMethods alertMethods;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
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
        elementMethods.clickElement(alertButton);
        alertMethods.acceptAlert();
    }

    public void clickAndDismissConfirm() {
        elementMethods.clickElement(confirmButton);
        alertMethods.dismissAlert();
    }

    public void clickAndFillAlertPrompt() {
        elementMethods.clickElement(promtButton);
        alertMethods.fillAlert("Daniel");
    }

    public void clickAndAcceptTimerAlert(){
        elementMethods.clickElement(timerAlertButton);
        alertMethods.acceptAlert();
    }
}
