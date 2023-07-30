package com.qa.testscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		
		Set <String>s=driver.getWindowHandles();
		
		for(String i:s) {
			System.out.println(i);
			 String T =driver.switchTo().window(i).getTitle();
			 System.out.println(T);
			 if(T.contains("Frames & windows"))
				 driver.close();
			
		}
		
		

	}

}
