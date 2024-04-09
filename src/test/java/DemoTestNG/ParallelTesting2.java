package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(threadPoolSize = 3,invocationCount = 4)
//    @Test(invocationCount = 4)
//    @Test
    public void test3_BootStrapAlerts() {
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");

//        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getId() +
                ": Bootstrap Alert Message Page");
//        driver.findElement(By.linkText("JQuery Date Picker")).click();
    }

    @Test
    public void test4_DragDropRangeSlider()  {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        System.out.println(Thread.currentThread().getId() +
                ":  Drag and drop  Range Slider Page");
//        Thread.sleep(2000);
    }
}
