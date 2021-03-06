package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_PartII {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Empty_Email_And_Password() {
		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),
				"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),
				"This is a required field.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123@456.789");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_03_Invalid_Password() {
		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),
				"Please enter 6 or more characters without leading or trailing spaces.");

	}
	@Test
	public void TC_04_Incorrect_Email_Password() {
		driver.get("http://live.demoguru99.com/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class=\"error-msg\"]//span")).getText(),
				"Invalid login or password.");
		
	}
	
	@Test
	public void TC_05_Create_New_Account() {
		driver.get("http://live.demoguru99.com/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath(".//a[@title='Create an Account']")).click();
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("New");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Account");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Customer");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("testerSe@lenium.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd1234");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("Abcd1234");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
				
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),
				"Thank you for registering with Main Website Store.");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}