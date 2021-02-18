package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_02_Xpath_Css_PartI {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test
	public void TC_01_ID() {
		// để thao tác vs 1 element ở trên page
		driver.findElement(By.id("FirstName")).sendKeys("Automation Testing");
		driver.findElement(By.id("Email")).sendKeys("automationtesting@gmail.com");
	}

	@Test
	public void TC_02_Classname() {
		driver.findElement(By.className("search-box-text")).sendKeys("Something");
	}

	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("Email")).sendKeys("hoantt@mailinator.com");
	}

	@Test
	public void TC_04_TagName() {
		System.out.println(driver.findElement(By.tagName("input")).getSize());
	}
	
	@Test
	public void TC_05_Link_Text() {
		Assert.assertTrue(driver.findElement(By.linkText("Digital downloads")).isDisplayed());
	}
	
	@Test
	public void TC_06_Partial_Link_Text() {
		Assert.assertTrue(driver.findElement(By.partialLinkText("Digital")).isDisplayed());
	}
	
	@Test
	public void TC_07_Css() {
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("Abcd@1234");
	}
	
	@Test
	public void TC_08_Xpath() {
		driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("1111111");
	}
	
	@AfterClass
	public void afterClass() {
			driver.quit();
	}

}