package pages;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;

    @FindBy(xpath = "//p")
    public WebElement textP;

    public void navigateToChildFrame() {
        frameMethods.switchToFrame("frame1");
        frameMethods.switchToIFrame(childFrame);
        System.out.println(textP.getText());
        frameMethods.defaultContent();
    }
}
