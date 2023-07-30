package com.qa.jscriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		
		String bgcolor = element.getCssValue("backgroundcolor");
		
		for(int i = 0; i<200;i++) {
			changeColor("#000000",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	public static void changeColor(String color,WebElement element,WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color +"'", element);
		
		Thread.sleep(10);
		
	}
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '3px solid blue'", element);
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message +"')");
	}
}
