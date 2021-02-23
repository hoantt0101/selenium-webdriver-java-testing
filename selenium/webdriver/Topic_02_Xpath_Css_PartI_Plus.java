package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_PartI_Plus {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Xpath_Format() {
		
		driver.get("https://demo.nopcommerce.com/");
		
		//ID
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).isDisplayed();
		
		//Class
		driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']")).isDisplayed();
		
		//Aria-label
		driver.findElement(By.xpath("//input[@aria-label='Search store']")).isDisplayed();
		
		//Placeholder
		driver.findElement(By.xpath("//input[@placeholder='Search store']")).isDisplayed();
		
		//name
		driver.findElement(By.xpath("//input[@name='q']")).isDisplayed();
		
		//index
		driver.findElement(By.xpath("//div[@class='search-box store-search-box']//input[1]")).isDisplayed();
		
	}

	@Test
	public void TC_02_() {
	}

	@Test
	public void TC_03_() {
	}

	@AfterClass
	public void afterClass() {
			driver.quit();
	}

}