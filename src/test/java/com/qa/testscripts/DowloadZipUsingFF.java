package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DowloadZipUsingFF {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk", "application/zip");//set MIME types::https://www.sitepoint.com/mime-types-complete-list/
		profile.setPreference("browser.dowload.manager.showWhenStarting", false);
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://testingmasters.com/student-corner/downloads/");
		driver.findElement(By.xpath("//*[@id=\"tablepress-7\"]/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
