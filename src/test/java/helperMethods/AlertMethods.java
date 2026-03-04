package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlert();
        Alert confirmTimerAlertButton = driver.switchTo().alert();
        System.out.println(confirmTimerAlertButton.getText());
        confirmTimerAlertButton.accept();
    }

    public void dismissAlert() {
        waitForAlert();
        Alert confirmButtonOK = driver.switchTo().alert();
        System.out.println(confirmButtonOK.getText());
        confirmButtonOK.dismiss();
    }

    public void fillAlert(String value) {
        Alert promtButtonOK = driver.switchTo().alert();
        System.out.println(promtButtonOK.getText());
        promtButtonOK.sendKeys(value);
        promtButtonOK.accept();

    }
}
