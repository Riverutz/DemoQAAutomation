package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class FramesMethods {
    public WebDriver driver;

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
