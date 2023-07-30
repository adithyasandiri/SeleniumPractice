package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingSikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Admin");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("admin123");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();

		//Add Employee element
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/header[1]/div[2]/nav[1]/ul[1]/li[3]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button")).click();
		
		String ImageFilePath = "E:\\Images";
		String inputFilePath = "E:\\Data";
		
		Screen s = new Screen();
		
		Pattern FileInputBox = new Pattern(ImageFilePath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(ImageFilePath + "OpenButton.PNG");
		
		Thread.sleep(5000);
		s.wait(FileInputBox,20);
		s.type(FileInputBox,inputFilePath +"anualprofile.jpg");
		s.click(openButton);
	
		
		Thread.sleep(3000);
		driver.close();
	}

}
