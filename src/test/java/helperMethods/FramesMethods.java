package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {
    public WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String text) {
        driver.switchTo().frame(text);
    }

    public void switchToIFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void defaultContent() {
        driver.switchTo().defaultContent();
    }
}
