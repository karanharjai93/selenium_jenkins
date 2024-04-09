package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeFailedScreenshots {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();//had to insert this options else it was giving websocket error
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void testSimpleFormDownload(){

        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input"))
                .sendKeys("TestNG is Awesome!!");
        driver.findElement(By.id("showInput")).click();
        String actualMessage =
                driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualMessage,
                "TestNG is Awesome!!!",
                "Message is not TestNG is Awesome!!!");
    }

    @AfterMethod
    public void takeScreenshotForFailures(ITestResult testResult){
        if(ITestResult.FAILURE==testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "" +
                    "/resources/screenshots/"+
                    testResult.getName()+".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
