package com.qa.testscripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/bus-booking");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//capture the links from the webpage
		List <WebElement> links =driver.findElements(By.tagName("a"));
		Thread.sleep(5000);
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement element=links.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			//create a connection using url object 'link'
			HttpURLConnection httpcon = (HttpURLConnection)link.openConnection();
			Thread.sleep(3000);
			
			httpcon.connect();//establish the connection
			
			int responseCode = httpcon.getResponseCode();//return response code .if response code is above 400 :: broken links
			if(responseCode>=400) {
				System.out.println(url +" - " + "is broken link");
			}
			else {
				System.out.println(url +" - "+ "is valid link");
			}
			
		}
		driver.close();
		

	}

}
