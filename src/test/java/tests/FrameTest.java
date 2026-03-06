package tests;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void frameTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertsFramesWindowsMenu);

        WebElement framesSubMenu = elementMethods.waitForElementVisibleByXpath("//span[text()='Frames']", 10);
        elementMethods.clickJSElement(framesSubMenu);

        frameMethods.switchToFrame("frame1");
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleHeading.getText());

        frameMethods.defaultContent();
        frameMethods.switchToFrame("frame2");
        WebElement frame2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(frame2.getText());
        frameMethods.defaultContent();

        WebElement nestedFramesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFramesSubMenu);

        frameMethods.switchToFrame("frame1");
        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        frameMethods.switchToIFrame(childFrame);

        WebElement text = driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());
    }
}
