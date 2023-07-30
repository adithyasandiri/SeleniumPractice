package com.qa.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotsApi {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("It is a Text box");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_DOWN);
		rt.keyPress(KeyEvent.VK_TAB);
		rt.keyPress(KeyEvent.VK_TAB);
		rt.keyPress(KeyEvent.VK_TAB);
		rt.keyPress(KeyEvent.VK_ENTER);
	}			
	

}
