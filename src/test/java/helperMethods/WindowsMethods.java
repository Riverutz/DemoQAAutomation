package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WindowsMethods {
    public WebDriver driver;

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
