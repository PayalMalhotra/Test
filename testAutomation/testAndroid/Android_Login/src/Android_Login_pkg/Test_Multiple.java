package Android_Login_pkg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Test_Multiple {

	 WebDriver driver = null;
	    int timeOut=180;
	    int port=-1;
	    
	    @Test
	    Test_Multiple(int port){
	        this.port=port;
	    }

	    public void testEmulator(int p) throws Exception {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	  
	        /*Properties prop = new Properties();
	    	InputStream input = null;
	    	
	    	
	    	input = new FileInputStream("C:\\Accolite\\new.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			String ver=prop.getProperty("version");
			System.out.println(ver);
			capabilities.setCapability(CapabilityType.VERSION, ver);*/
		      
	       capabilities.setCapability(CapabilityType.VERSION, "6.0");
	     //   capabilities.setCapability(CapabilityType.PLATFORM, "Windows");

	        capabilities.setCapability("deviceName", "Android Emulator");

	  		  // Set android platformName desired capability. It's Android in our case here.
	  	  capabilities.setCapability("platformName", "Android");

	        capabilities.setCapability("app", "C:\\Accolite\\Softwares\\android-sdk_r24.4.1-windows\\android-sdk-windows\\platform-tools\\app-debug.apk");

	       // = "apps/android-learn-debug.apk"


	        capabilities.setCapability("udid","emulator-"+p);

	        capabilities.setCapability("app-package", "com.android.calculator2");
	        capabilities.setCapability("app-activity", "com.android.calculator2.Calculator");
	       
	        driver = new RemoteWebDriver(new URL("http://127.0.0.1:"+this.port+"/wd/hub"),
	        capabilities);
	        
	        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	        Thread.sleep(50000);
	    }

	    public void tearDown() {
	        if (driver != null)
	            driver.quit();
	    }

	    public void runTest() {
	        try {
	            testEmulator(5554);     // for emulator on port 5554
	            tearDown();
	            testEmulator(5556);     // for emulator on port 5556
	            tearDown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    public static void main(String[] args) {
	        new Test_Multiple(4725).runTest();       // appium server port 4723
	    }
	

}
