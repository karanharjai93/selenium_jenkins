package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
    WebDriver driver;

    @Parameters({"URL"})
    @BeforeClass
    public void setUp(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();//had to insert this options else it was giving websocket error
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    //Step.1 Load the AUT(Application Under Test).
        driver.get(url);
    }

    @Test
    @Parameters({"Task","TestResult"})
    public void testFileDownload(String task,String testResult){
    //Step 2. Click the File Download Link.
        driver.findElement(By.linkText("File Download")).click();
        // Step 3. Enter Data.
        driver.findElement(By.id("textbox")).sendKeys(task +
                " Execution : " + testResult);
        //step 4: Clicl the generate file button
        driver.findElement(By.id("create")).click();
        //step 5: Click the download Link.
        driver.findElement(By.id("link-to-download")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
