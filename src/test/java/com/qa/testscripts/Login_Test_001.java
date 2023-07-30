package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test_001 {
	public static WebDriver driver;
	
	public static String Browser = "edge";

	public static void main(String[] args) throws InterruptedException {
		if(Browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
