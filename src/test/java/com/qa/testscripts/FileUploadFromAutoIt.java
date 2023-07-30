package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadFromAutoIt {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		Thread.sleep(5000);
		WebElement Upload = driver.findElement(By.xpath("//*[@id='imagesrc']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Upload);
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\YatraProject\\AutomationProject\\com.testautomation.selenium\\src\\test\\java\\com\\qa\\testdata\\fileuploads.exe"+" "+"E:\\YatraProject\\AutomationProject\\com.testautomation.selenium\\src\\test\\java\\com\\qa\\testdata\\anualprofile.jpg");

	}

}
