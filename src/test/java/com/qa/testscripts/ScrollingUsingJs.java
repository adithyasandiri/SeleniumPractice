package com.qa.testscripts;


import org.testng.annotations.Test;

public class ScrollingUsingJs extends TestBase {
	
	@Test
	public void Scrolling() throws InterruptedException{
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		//1.Scrolling by using pixel
		//Js.executeScript("window.scrollBy(0,1000)", "");
		
		//2.Scrolling page till we find element
		//WebElement flag = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[1]/tbody/tr[86]/td[1]/img"));
		//Js.executeScript("arguments[0].scrollIntoView();", flag);
		
		//3.Scroll page till bottom
		Js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
		
	}

}
