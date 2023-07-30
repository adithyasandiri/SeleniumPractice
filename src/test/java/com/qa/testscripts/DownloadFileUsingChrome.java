package com.qa.testscripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileUsingChrome {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Iam Happy to learn new things");
		driver.findElement(By.id("createTxt")).click();//click on generate file
		driver.findElement(By.id("link-to-download")).click();//click to download
		Thread.sleep(5000);
		if(isFileExit("C://Users//Sandiri AdithyaReddy//Downloads//info.txt")) {
			System.out.println("File Exists");
		}
		else {
			System.out.println("File not Exists");
		}
		
		driver.findElement(By.id("pdfbox")).sendKeys("Thank You");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		Thread.sleep(5000);
		
		if(isFileExit("C://Users//Sandiri AdithyaReddy//Downloads//info.pdf")) {
			System.out.println("File Exists");
		}
		else {
			System.out.println("File not Exists");
		}
		driver.close();

	}
	static boolean isFileExit(String path) {
		
		File f = new File(path);
		
		if(f.exists()) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
