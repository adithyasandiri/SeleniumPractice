package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileUsingSikuli {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("imagesrc")).click();
		
		String ImageFilePath = "E:\\YatraProject\\AutomationProject\\com.testautomation.selenium\\src\\test\\java\\com\\qa\\images\\";
		String inputFilePath = "E:\\YatraProject\\AutomationProject\\com.testautomation.selenium\\src\\test\\java\\com\\qa\\testdata\\";
		
		Screen s = new Screen();
		
		Pattern FileInputBox = new Pattern(ImageFilePath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(ImageFilePath + "OpenButton.PNG");
		
		Thread.sleep(5000);
		s.wait(FileInputBox,20);
		s.type(FileInputBox,inputFilePath +"photo.jpg");
		s.click(openButton);
		driver.close();
	}

}
