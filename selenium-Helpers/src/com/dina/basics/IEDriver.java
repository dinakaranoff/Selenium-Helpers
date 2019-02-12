package com.dina.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:/Users/dinakaran.palaniswam/Downloads/IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
		InternetExplorerOptions options=new InternetExplorerOptions();
		options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
        options.enableNativeEvents();
        options.UnhandledPromptBehavior = UnhandledPromptBehavior.Accept;
        options.EnablePersistentHover = true;
        options.EnableNativeEvents = false;
        options.EnsureCleanSession = true;  
//	DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
//	cap.acceptInsecureCerts();
//	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	WebDriver driver=new InternetExplorerDriver();
	driver.get("https://cacert.org/");
	
	//driver.findElement(By.id("moreInformationAlign")).click();
	driver.navigate().to("javascript:document.getElementById('moreInfoContainer').click()");
	driver.navigate().to("javascript:document.getElementById('overridelink').click()");
	
	}
	

}
