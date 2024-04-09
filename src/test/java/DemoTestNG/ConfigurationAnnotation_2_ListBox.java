package DemoTestNG;

import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotation_2_ListBox {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("   Execute before each test method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("   Execute after each test method \n");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("  Execute Before Class: ListBox");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("  Execute After Class: ListBox");
    }

    public void test3_BootstrapListBox(){
        System.out.println("    Test Method 3 :Bootstrap List Box");
    }

    public void test4_JQueryListBox(){
        System.out.println("    Test Method 4 :JQuery ListBox");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println(" Execute Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println(" Execute after Test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Execute Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Execute After Suite");
    }

    @BeforeGroups(groups = {"regression","smoke"})
    public void beforeGroup(){
        System.out.println("Execute Before Group");
    }

    @AfterGroups(groups = {"regression","smoke"})
    public void afterGroup(){
        System.out.println("Execute After Group");
    }

}








































