package com.qa.testscripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement element = driver.findElement(By.id("animals"));
		Select se = new Select(element);
		
		List orginalL = new ArrayList();
		List tempL = new ArrayList();
		List <WebElement>options = se.getOptions();
		for(WebElement e:options) {
			orginalL.add(e.getText());
			tempL.add(e.getText());
		}
		
		System.out.println(orginalL);
		
		
		Collections.sort(tempL);
		System.out.println(tempL);
		
		driver.close();

	}


}
