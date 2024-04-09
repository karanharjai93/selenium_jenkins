package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotation_1_DatePickers {
    @Test(groups = "smoke")
    public void test1_BootstrapDatePicker(){
        System.out.println("    Test Method 1 :Bootstrap date picker");
    }
    @Test(groups = {"regression","e2e"})
    public void test2_JQueryDatePicker(){
        System.out.println("    Test Method 2 :JQuery date picker");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("   Execute before each test method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("   Execute after each test method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("  Execute Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("  Execute After Class");
    }
}
