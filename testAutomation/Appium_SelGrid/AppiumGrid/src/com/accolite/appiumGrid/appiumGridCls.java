package com.accolite.appiumGrid;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class appiumGridCls 
{
	WebDriver driver;

	
	 @Test
	 @Parameters({"device"})
	 public void setUp(String device) throws Exception 
	 {

	  // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  capabilities.setCapability("deviceName", device);
	  
	  // Set android platformName desired capability. It's Android in our case here.
	  capabilities.setCapability("platformName", "Android");
	
	  // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  capabilities.setCapability("appPackage", "com.android.calculator2");

	  // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
	  // Set your application's appPackage if you are using any other app.
	  capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	  
	  // Created object of RemoteWebDriver will all set capabilities.
	  // Set Grid server address and port number in URL string.
	  // It will launch calculator app in emulator.
	  
	  
	  //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
	  
	  //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), capabilities);
	  
	  
	  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), capabilities);
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  // Click on number 2 button.
	  driver.findElement(By.name("2")).click();

	  // Click on + button.
	  driver.findElement(By.name("+")).click();

	  // Click on number 5 button.
	  driver.findElement(By.name("5")).click();

	  // Click on = button.
	  driver.findElement(By.name("=")).click();

	  // Get result from result text box of calc app.
	  String result = driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number sum result is : " + result);
	  
	  //driver.quit();

}
	 
}	 
