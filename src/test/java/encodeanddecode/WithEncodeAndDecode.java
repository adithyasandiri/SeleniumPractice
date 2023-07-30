package encodeanddecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.testscripts.TestBase;

public class WithEncodeAndDecode extends TestBase {
	@Test()
	public void EncodeAndDecode() {
		driver.get("https://demo.nopcommerce.com/login");
		
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.id("Email")).sendKeys("pavanoltraining@gmail.com");
		driver.findElement(By.id("Password")).sendKeys(decodeString("dGVzdDEyMw=="));
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
	}

	static String decodeString(String password) {
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}

}
