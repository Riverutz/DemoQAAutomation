package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    public WebElement frame1Heading;

    @FindBy(id = "sampleHeading")
    public WebElement frame2Heading;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFramesSubMenu;

    public void readLargeFrameHeading() {
        framesMethods.switchToFrame("frame1");
        System.out.println(frame1Heading.getText());
        framesMethods.defaultContent();
    }

    public void readSmallFrameHeading() {
        framesMethods.switchToFrame("frame2");
        System.out.println(frame2Heading.getText());
        framesMethods.defaultContent();
    }

    public void navigateToNestedFramesSubMenu() {
        elementsMethods.clickJSElement(nestedFramesSubMenu);
    }
}

