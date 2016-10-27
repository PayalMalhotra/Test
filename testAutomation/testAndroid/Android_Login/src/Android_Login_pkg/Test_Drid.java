package Android_Login_pkg;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;


public class Test_Drid {
	
	public void setup throws Exception()
	
	{
	
	 // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  // Set android deviceName desired capability.
	  capabilities.setCapability("deviceName", "Android Emulator");

	  // Set browserName desired capability.
	  capabilities.setCapability("browserName", "Android");

	  // Set your emulator's android version.
	  capabilities.setCapability("platformVersion", "6.0");

	  // Set android platformName desired capability.
	  capabilities.setCapability("platformName", "Android");

	 
	  capabilities.setCapability("appPackage", "com.accolite.loginapp");

	  capabilities.setCapability("appActivity", "com.accolite.loginapp.LoginActivity");

	  // It will launch calculator app in emulator.
	  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //Grid
	  
	//  WebDriver driver = new RemoteWebDriver(new URL("http://<WindowsXP-ip>:4444/wd/hub"), capabilities);
	  

	}

}
