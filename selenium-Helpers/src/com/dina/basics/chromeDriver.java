package com.dina.basics;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class chromeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chromeDriver obj=new chromeDriver();
		obj.openchrome();
	}

	private void openchrome() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/dinakaran.palaniswam/Downloads/chromedriver_win32/chromedriver.exe");
		ChromeOptions option=new ChromeOptions();		
		option.setAcceptInsecureCerts(true);
		option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	  	WebDriver driver=new ChromeDriver(option);
	  	driver.get("https://localhost.digicert.com/account/logout.php");

	}
	
	private void handle_SSL() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/dinakaran.palaniswam/Downloads/chromedriver_win32/chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		option.setAcceptInsecureCerts(true);
		option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	  	WebDriver drive=new ChromeDriver(option);
	
		}
	
	
	//Use Desired Capabilities		
	private void handle_SSL2() {
		DesiredCapabilities cap=DesiredCapabilities.chrome(); 
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	  	WebDriver drive=new ChromeDriver(cap);
	}
		
		
	private void disable_popup(){	
		System.setProperty("webdriver.chrome.driver", "C:/Users/dinakaran.palaniswam/Downloads/chromedriver_win32/chromedriver.exe");
		ChromeOptions option=new ChromeOptions();

		//TO hide auto-info bar "Chrome is being controlled by automated test software" information at the top
		option.addArguments("disable-infobars");
		
		//disbale browser level notification
  		option.addArguments("--disable-notifications");  
		
		//Load Default/Custom Chrome Profile
		option.addArguments("user-data-dir=C:/Users/dinakaran.palaniswam/AppData/Local/Google/Chrome/User Data");

		//Using a Chrome executable in a non-standard location. This is for other than default location
	//option.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		
		//for headless excution
		option.setHeadless(true);
	
		//Add Extension
		option.addExtensions(new File("C:\\Users\\dinakaran.palaniswam\\Downloads\\Xdebug-helper_v1.6.1.crx"));
		WebDriver driver=new ChromeDriver(option);	
		driver.get("https:\\www.google.com");
	}
	
	public void readProfile(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/dinakaran.palaniswam/Downloads/chromedriver_win32/chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		Object val=option.getCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR);
		System.out.println("Value "+val.toString());
		val=option.getCapability(CapabilityType.ACCEPT_SSL_CERTS);
		System.out.println("Value "+val.toString());
		val=option.getBrowserName();
		
	}

}
