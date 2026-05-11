package sharedData;

import loggerutility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

@Getter
public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        LoggerUtility.info("Starting test environment setup");

        driver = new ChromeDriver(options);
        LoggerUtility.info("ChromeDriver initialized");

        driver.get("https://demoqa.com/");
        LoggerUtility.info("Navigated to application URL");

        driver.manage().window().maximize();
        LoggerUtility.info("Browser window maximized");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("Implicit wait set to 10 seconds");
        LoggerUtility.info("Test environment ready");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (!result.isSuccess()){
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        driver.quit();
        LoggerUtility.info("Browser closed successfully");
    }
}
