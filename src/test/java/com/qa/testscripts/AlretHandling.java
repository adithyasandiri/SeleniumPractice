package com.qa.testscripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlretHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
		
		//Alert box with ok button Example
		//switch to alert box
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();//ok button clicked and close the alert
		
		driver.close();
		
		
	}

}
