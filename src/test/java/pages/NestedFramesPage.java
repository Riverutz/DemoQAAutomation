package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage{
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;

    @FindBy(xpath = "//p")
    public WebElement textP;

    public void navigateToChildFrame() {
        framesMethods.switchToFrame("frame1");
        framesMethods.switchToIFrame(childFrame);
        System.out.println(textP.getText());
        framesMethods.defaultContent();
    }
}
