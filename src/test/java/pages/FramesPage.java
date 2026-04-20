package pages;

import loggerutility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
        LoggerUtility.info("FramesPage initialized");
    }

    @FindBy(id = "sampleHeading")
    private WebElement frame1Heading;

    @FindBy(id = "sampleHeading")
    private WebElement frame2Heading;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesSubMenu;

    public void readLargeFrameHeading() {
        LoggerUtility.info("Switching to Frame 1");
        framesMethods.switchToFrame("frame1");

        LoggerUtility.info("Reading text from Frame 1 heading");
        LoggerUtility.info("Frame 1 heading: " + frame1Heading.getText());

        LoggerUtility.info("Switching back to default content");
        framesMethods.defaultContent();
    }

    public void readSmallFrameHeading() {
        LoggerUtility.info("Switching to Frame 2");
        framesMethods.switchToFrame("frame2");

        LoggerUtility.info("Reading text from Frame 2 heading");
        LoggerUtility.info("Frame 2 heading: " + frame2Heading.getText());

        LoggerUtility.info("Switching back to default content");
        framesMethods.defaultContent();
    }

    public void navigateToNestedFramesSubMenu() {
        LoggerUtility.info("Clicking 'Nested Frames' submenu");
        elementsMethods.clickJSElement(nestedFramesSubMenu);
    }
}

