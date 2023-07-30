package WebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalCommends {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		//USer name field
		WebElement Email =  driver.findElement(By.id("email"));
		
		if(Email.isDisplayed() && Email.isEnabled()) {
			Email.sendKeys("adithyasandri");
		}
		else {
			System.out.println("Something went worng in Email TextBox!");
		}
		//Password Field
		WebElement Pass = driver.findElement(By.id("pass"));
		if(Pass.isDisplayed() && Pass.isEnabled()) {
			Pass.sendKeys("Rohith@123");
		}
		else {
			System.out.println("Something Wrong with password field!");
		}
		
		//Login Button
		WebElement login = driver.findElement(By.name("login"));
		if(login.isDisplayed() && login.isEnabled()) {
			login.click();
		}
		else {
			System.out.println("Something wrong with login button");
		}
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.close();

	}

}
