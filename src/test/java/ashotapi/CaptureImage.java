package ashotapi;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.jscriptexecutor.JavaScriptUtil;
import com.qa.testscripts.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureImage extends TestBase {
	
	@Test()
	public void CaptureLogo() throws IOException, InterruptedException{
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
		
		JavaScriptUtil.drawBorder(logoElement, driver);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", logoElement);
		
		Screenshot logoScreenshot = new AShot().takeScreenshot(driver, logoElement);//capturing the screenshot
		File src = new File("E://ScreenShot/facebook.png");
		ImageIO.write(logoScreenshot.getImage(), "png", src);
		//File file = new File("E://ScreenShot/facebook.png");
		if(src.exists()) {
			System.out.println("Image File Captured");
		}
		else {
			System.out.println("File not exist");
		}
	}


}
