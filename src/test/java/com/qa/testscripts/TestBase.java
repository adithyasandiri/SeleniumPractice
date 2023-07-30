package com.qa.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	JavascriptExecutor Js;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Js = (JavascriptExecutor)driver;
		
		
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
