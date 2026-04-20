package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage{
    public NestedFramesPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("NestedFramesPage initialized");
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;

    @FindBy(xpath = "//p")
    private WebElement textP;

    public void navigateToChildFrame() {
        LoggerUtility.info("Switching to parent frame (frame1)");
        framesMethods.switchToFrame("frame1");

        LoggerUtility.info("Switching to child iframe");
        framesMethods.switchToIFrame(childFrame);
        LoggerUtility.info("Reading text from child frame: " + textP.getText());

        LoggerUtility.info("Switching back to default content");
        framesMethods.defaultContent();
    }
}
