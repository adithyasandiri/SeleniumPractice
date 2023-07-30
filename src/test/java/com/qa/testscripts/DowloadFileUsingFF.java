package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DowloadFileUsingFF {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		
		//creating the browser profile
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk", "text/plain");//set MIME types::https://www.sitepoint.com/mime-types-complete-list/
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		WebDriver driver = new FirefoxDriver(option);
		
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Iam Happy to learn new things");
		driver.findElement(By.id("createTxt")).click();//click on generate file
		driver.findElement(By.id("link-to-download")).click();//click to download
		driver.close();
	}

}
