package helperMethods;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {
    public WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchSpecificTab(Integer index) {
        List<String> newTabButtonSwitch = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabButtonSwitch.get(index));
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void quitPage() {
        driver.quit();
    }
}
