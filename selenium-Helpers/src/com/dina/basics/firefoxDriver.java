package com.dina.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class firefoxDriver {
	
	public void initFF(){
		System.setProperty("webdriver.gecko.driver", "C:/Users/dinakaran.palaniswam/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.mozilla.org/en-US/");
	}
	
 // Selenium 2 code. This requires standalone server 2.53. But may not work 
   
   	public void use_default_profile(){
		System.setProperty("webdriver.gecko.driver", "C:/Users/dinakaran.palaniswam/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		String browserprofile = System.getProperty("webdriver.firefox.profile");//default profile
		FirefoxProfile profile=getProfile(browserprofile);
		profile.setPreference("browser.startup.homepage", "https://www.google.com");
		FirefoxOptions option=new FirefoxOptions(); //In selenium2 this code wont come
		option.setProfile(profile);
		WebDriver driver=new FirefoxDriver(option);
		driver.get("https://expired.badssl.com/");
	}
	
	
	//Selenium 3
		public void use_existing_profle(){
			System.setProperty("webdriver.gecko.driver", "C:/Users/dinakaran.palaniswam/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
			String browserprofile = System.getProperty("webdriver.firefox.profile");
			FirefoxProfile profile=getProfile("DinaProfile"); //Custumized profile
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile);
			WebDriver driver=new FirefoxDriver(firefoxOptions);
			driver.get("https://expired.badssl.com/");
		}
	
		public void handle_SSL_cert(){
			System.setProperty("webdriver.gecko.driver", "C:/Users/dinakaran.palaniswam/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
			FirefoxProfile profile=new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true); // I feel it is not working if true false both condition
			//profile.setAssumeUntrustedCertificateIssuer(false); 
			FirefoxOptions option= new FirefoxOptions();
			option.setProfile(profile);
			WebDriver driver=new FirefoxDriver(option);
			driver.get("https://cacert.org/");
		}
	
	public void sleep(int num){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FirefoxProfile setPreference(FirefoxProfile profile){
		profile.setPreference("browser.startup.homepage", "https://www.google.com/");
		profile.setAcceptUntrustedCertificates(true);
		return profile;
	}
	
	FirefoxProfile getProfile(String profile){
		if(profile==null || profile.isEmpty()){
			return new FirefoxProfile();
		}
		return new ProfilesIni().getProfile(profile);
	}
	
//  public  void initDrivers(String browser){
//	  switch(browser){
//		  case "firefox":
//			  driver=new FirefoxDriver();
//			  driver.get("www.google.com");
//			   break;
//		  case "chrome":
//			  break;
//		  case "IE":
//			  break;
//	  }
//	  System.out.println("Launched browser "+browser);
//  }
	
  public void  open(){
	  WebDriver driver = null;	
		driver.get("www.google.com");
	   System.out.println("uri is opened");
  }
  
	public static void main(String[] args) {
		firefoxDriver obj=new firefoxDriver();
		obj.use_default_profile();
		obj.use_existing_profle();
		obj.handle_SSL_cert();
	}

}
