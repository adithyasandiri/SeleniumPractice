package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithOk {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		
		String ExpectedOk = "You pressed Ok";
		
		
		//For OK button
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		driver.switchTo().alert().accept();
		
		String ActualTextOK = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[1]")).getText();
		if(ExpectedOk.equals(ActualTextOK)) {
			System.out.println("Test is passed for ok button");
		}
		else {
			System.out.println("Test is failed for ok button");
		}
		
		//For Cancel Button
		
		String ExpectedCancel = "You Pressed Cancel";
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		driver.switchTo().alert().dismiss();

		String ActualTextCancel = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[1]")).getText();
		if(ExpectedCancel.equals(ActualTextCancel)) {
			System.out.println("Test is passed for Cancel button");
		}
		else {
			System.out.println("Test is failed for Cancel button");
		}
		driver.close();
	}

}
