package ashotapi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.testscripts.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImage extends TestBase {
	@Test()
	public void Compare() throws IOException {
		driver.get("https://www.facebook.com/");
		
		BufferedImage ExpectedImage = ImageIO.read(new File("E://ScreenShot/yatra.png"));
		
		WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
		Screenshot logoScreenshot =new AShot().takeScreenshot(driver, logoElement);//takes screenshot and save it to the variable
		BufferedImage actualImage =logoScreenshot.getImage();//capture image from screenshot
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(ExpectedImage, actualImage);
		
		if(diff.hasDiff()==true) {
			System.out.println("Images are not same");
		}else {
			System.out.println("Images are same");
		}
		
		
	}

}
