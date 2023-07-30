package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("gym");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(5000);
		
		String ExpTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		String Acttitle = driver.getTitle();
		if(ExpTitle.equals(Acttitle)) {
			System.out.println("Test is passed");
		}else {
			System.out.println("Test is failed");
		}
		driver.close();
	}

}
