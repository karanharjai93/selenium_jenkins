package com.lambdatest.pages;


import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private By bootStrapProgressBar = By.linkText("Bootstrap Progress bar");

    public BootStrapProgressBarPage clickBootStrapProgressBar(){

         click(bootStrapProgressBar);
        return new BootStrapProgressBarPage();
    }
}









//import org.openqa.selenium.By;
//
//public class HomePage extends BasePage{
//
//    private By bootStrapProgressBar = By.linkText("Bootstrap Progress bar");
//
//    public BootStrapProgressBarPage clickBootStrapProgressBar(){
//        click(bootStrapProgressBar);
//        return new BootStrapProgressBarPage();
//    }
//}
