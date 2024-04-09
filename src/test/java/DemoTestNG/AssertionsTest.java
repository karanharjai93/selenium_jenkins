package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

    SoftAssert softAssert = new SoftAssert();//declaration needed only for
    //soft assertions for hard assertions this is not required.
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
    public void testSingleCheckBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMessage = driver.findElement(By.id("txtAge")).getText();
        Assert.assertTrue(actualMessage.contains("Check"),
                "\n Message does not contains Check \n");
    }

    @Test
    public void testRadioButtons(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath(
                "//input[@value='Male' and @name='gender']"))
                .click();
        driver.findElement(By.xpath(
                "//input[@value='5 - 15']"
        )).click();
        driver.findElement(By.xpath("//button[text()='Get values']"
        )).click();
        String actualGender =
                driver.findElement(By.cssSelector(".genderbutton")).getText();
        String actualAgeGroup =
                driver.findElement(By.cssSelector(".groupradiobutton")).getText();

        //Example of Hard Assert
        //After first assert fails it didn't executed the second assert
//        Assert.assertEquals(actualGender,"Female",
//                "\n Actual Gender is not Correct \n");
//        Assert.assertTrue(actualAgeGroup.contains("34"),
//                "\n Actual agegroup is not correct \n");

        //Example of Soft Assert
        //After first assert fails it still executed the second assert
//        softAssert.assertEquals(actualGender,"Female",
//                "\n Actual Gender is not Correct \n");
//        softAssert.assertTrue(actualAgeGroup.contains("34"),
//                "\n Actual agegroup is not correct \n");
//
//        //Without this line it will pass both the tests and dont show
//        // error message also even tough it should fail
//       //The message argument is optional
//        softAssert.assertAll("\n Test Soft Assert");

        //if we make second assertion pass , test will
        //still fail but the second assertion will be
        //verified and its error message wont be printed
        //as it is a softassert it didnt stopped execution
        //after first assert failed.

        softAssert.assertEquals(actualGender,"Female",
                "\n Actual Gender is not Correct \n");
        softAssert.assertTrue(actualAgeGroup.contains("15"),
                "\n Actual agegroup is not correct \n");

        softAssert.assertAll();
    }

}
