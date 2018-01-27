package Scenarios2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Mortgage_App_EMI {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Device details
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				capabilities.setCapability("deviceName", "GT-I9300I");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.4");
				
				//app details
				capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
				capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");
				
				//Appium details
				
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				String Exp_Result="222.44";
				System.out.println("Expected Result is "+Exp_Result);
				
				Thread.sleep(5000);
				
				driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
				driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
				driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
				
				driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
				Thread.sleep(5000);
				
				String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
				System.out.println("Output is  "+Output);
				
				String Actual_Result = Output.replace("$", "");
				System.out.println("Actual Result is "+Actual_Result);
				
				if(Actual_Result.equals(Exp_Result))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				
				
				

	}

}
