package com.lambdatest.tests;


import com.lambdatest.pages.BootStrapProgressBarPage;
import com.lambdatest.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();
    BootStrapProgressBarPage progressBarPage;
    @Test
    public void testProgressBarPercentage(){

        progressBarPage = homePage.clickBootStrapProgressBar();
        progressBarPage.clickStartDownloadButton();

        String actualPercentage = progressBarPage.getProgressBarPercentage();

        String actualMessage = progressBarPage.getCompletedMessage();

        String expectedPercentage ="100%";
        String expectedMessage = "Download completed!";

        softAssert.assertEquals(actualPercentage,expectedPercentage,
                "\n Percentage is not 100% \n");

        softAssert.assertEquals(actualMessage,expectedMessage,
                "\n Message is not complete or correct \n");

        softAssert.assertAll();
    }


}









//import com.lambdatest.pages.BootStrapProgressBarPage;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class ProgressBarTest extends BaseTest{
//    SoftAssert softAssert = new SoftAssert();
////    BootStrapProgressBarPage progressBarPage = new BootStrapProgressBarPage();
//
//    BootStrapProgressBarPage progressBarPage;
//    @Test
//    public void testProgressBarPercentage(){
//        progressBarPage = homepage.clickBootStrapProgressBar();
//        progressBarPage.clickStartDownloadButton();
//        String actualMessage = progressBarPage.getCompletedMessage();
//       String actualPercentage =  progressBarPage.getProgressBarPercentage();
//       String expectedMessage = "Download completed!";
//       String expectedPercentage = "100%";
//       softAssert.assertEquals(actualMessage,expectedMessage ,
//               "\n Message is not complete or correct \n");
//       softAssert.assertEquals(actualPercentage,expectedPercentage,
//               "\n Percentage is not 100% \n");
//       softAssert.assertAll();
//    }
//}
