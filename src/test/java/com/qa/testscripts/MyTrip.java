package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTrip {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();


		String location = "Hyderabad";

		driver.get("https://www.mytrip.com/rf/destination?domain=google-a&campaign=brand-XX&text=7&gclid=Cj0KCQjwteOaBhDuARIsADBqRejYCO9Bhx00e9qW00gk47idoZlKu-1GCG_kcbbKedEksstym9M8IlMaAv3tEALw_wcB");



		Thread.sleep(5000);

		WebElement from = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[2]/div/div/form/div[1]/div[1]/div/div[1]/label/div[2]/div/div[1]/div[2]"));
		
		String js = "arguments[0].setAttribute('From','"+location+"')";
				((JavascriptExecutor)driver).executeScript(js, from);
				
				
				((JavascriptExecutor) driver).executeScript("document.getElementById('ID').style.display='block';");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();",from);
//		Thread.sleep(3000);
//		from.sendKeys("Hyderabad");
		//js.executeScript("document.getElementByXpath('//*[@id=\"root\"]/div/div[2]/main/section/div[2]/div/div/form/div[1]/div[1]/div/div[1]/label/div[2]/div/div[1]/div[2]').setAttribute('From','Hyderabad')");
	}


}
