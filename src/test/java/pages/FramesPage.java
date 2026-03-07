package pages;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement frame1Heading;

    @FindBy(id = "sampleHeading")
    public WebElement frame2Heading;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFramesSubMenu;

    public void readLargeFrameHeading() {
        frameMethods.switchToFrame("frame1");
        System.out.println(frame1Heading.getText());
        frameMethods.defaultContent();
    }

    public void readSmallFrameHeading() {
        frameMethods.switchToFrame("frame2");
        System.out.println(frame2Heading.getText());
        frameMethods.defaultContent();
    }

    public void navigateToNestedFramesSubMenu() {
        elementMethods.clickJSElement(nestedFramesSubMenu);

    }
}

