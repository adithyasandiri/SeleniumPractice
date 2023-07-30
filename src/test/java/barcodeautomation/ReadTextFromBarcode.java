package barcodeautomation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.qa.testscripts.TestBase;

public class ReadTextFromBarcode extends TestBase {

	@Test()
	public void BarcodeReader() throws IOException, NotFoundException {
		
		driver.get("https://qrcode.meetheed.com/qrcode_examples.php");
		String barcodeUrl = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/div[1]/div[2]/div[1]/img")).getAttribute("src");
		//creating an object of URL Class
		URL url = new URL(barcodeUrl);
		
		//pass the url class object to store the file as image
		BufferedImage bufferedimage = ImageIO.read(url);
		
		//Process the image
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binarybBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		//capture the details of QR code
		Result result = new MultiFormatReader().decode(binarybBitmap);
		System.out.println(result.getText());
	}
}
