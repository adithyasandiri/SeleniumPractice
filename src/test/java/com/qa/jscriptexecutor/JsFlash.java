package com.qa.jscriptexecutor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.testscripts.TestBase;

public class JsFlash extends TestBase {

	@Test()
	public void ElementFlash() throws InterruptedException, IOException{
		driver.get("https://www.yatra.com/");
		
		//WebElement searchFlights = driver.findElement(By.xpath("//*[@id=\"BE_flight_flsearch_btn\"]"));
		//flashing
		//JavaScriptUtil.flash(searchFlights, driver);
		
		//Draw border
		//JavaScriptUtil.drawBorder(searchFlights, driver);
		
		
		/*//To Capture ScreenShot
		File src = ((TakesScreenshot )driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("E://ScreenShot/yatra.png");
		FileUtils.copyFile(src, trg);
		*/
		
		/*//Capture the title of  a page using JS
		String title = JavaScriptUtil.getTitleByJS(driver);
		Reporter.log(title,true);
		System.out.println(title);*/
		
		//generating alert window
		WebElement busTab = driver.findElement(By.xpath("//*[@id=\"booking_engine_buses\"]"));
		busTab.click();
		Thread.sleep(3000);
		JavaScriptUtil.generateAlert(driver, "You clicked the BusSearch button");
	}

}
