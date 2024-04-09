package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting1 {

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

    @Test
    public void test1_JQueryDatePicker()  {
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");

//        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getId() +
                ": JQuery Date Picker Page");
//        driver.findElement(By.linkText("JQuery Date Picker")).click();
    }

    @Test
    public void test2_DataListFilter() {
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
        System.out.println(Thread.currentThread().getId() +
                ":  Data List Filter Page");
//        Thread.sleep(2000);
    }
}
