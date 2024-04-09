package DemoTestNG;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class First_Automated_Test {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();//had to insert this options else it was giving websocket error
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        //if i wrote ChromeDriver driver = new Chromedriver(options)
        //it was throwing error that findElement in @Test was not defined
        //basically null pointer error sort of, upon searching I found that
        //as Webdriver driver defined outside this method this.driver made initialization
        //to the driver field at class level whereas the first option did initialization
        //at method level.
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }

    @Test(priority = 1)
    public void testTableSortAndSearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(
        By.xpath("//div[@id='example_filter']//input[@type='search']"))
                .sendKeys("A. Satou");
    }

    @Test(priority = 2)
    public void bootstrapDatePicker(){
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.id("birthday")).sendKeys("06/07/2008");
//        driver.navigate().back();
    }

}
