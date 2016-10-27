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

public class Android_Login_cls {
	WebDriver driver;

	 @Test
	 public void setUp() throws Exception 
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
	  
	  // TC - Verify App Name
	String app_name=  driver.findElement(By.name("Multiplayer Demo")).getText();
	  
	 Assert.assertEquals(app_name,"Multiplayer Demo");
	 
	 
	 // ******* Login
	
	 // 1 - By new creds
	 driver.findElement(By.className("android.widget.Button")).click();
	  
	 driver.findElement(By.id("com.accolite.loginapp:id/email_id")).sendKeys("abc@gmail.com");	  
	
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	 driver.findElement(By.id("com.accolite.loginapp:id/pass_word")).sendKeys("12345678");
	 
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 
	 driver.findElement(By.id("com.accolite.loginapp:id/loginId")).click();
	 
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	// driver.findElement(By.name("Welcome,Login Successful")).isDisplayed();
	 
	 //2 . By FB 
	 
	 driver.findElement(By.id("com.accolite.loginapp:id/fbId")).click();
	 
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 
	 
	 //3.  BY google
	 
	 driver.findElement(By.name("Signup with Google+")).click();
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 
	 driver.findElement(By.className("android.widget.EditText")).sendKeys("abc@gmail.com");	 
	 
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 
	 
	 //  TC - Play Game
	 
	 driver.findElement(By.id("com.accolite.loginapp:id/play_game")).click();
	 
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 
	  
	
	 }
}
