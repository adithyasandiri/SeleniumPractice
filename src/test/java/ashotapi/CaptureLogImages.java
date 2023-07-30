package ashotapi;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogImages {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
		Thread.sleep(5000);
		Screenshot logoScreenshot = new AShot().takeScreenshot(driver, logoElement);
		ImageIO.write(logoScreenshot.getImage(), "png", new File("E://ScreenSho/facebook.png")); //storing as a file formatt
		
		File f = new File("E://ScreenShot/facebook.png");
		if(f.exists()) {
			System.out.println("Image file Exists");
		}else {
			System.out.println("Image File Not Exists");
		}
		driver.close();

	}

	
}
