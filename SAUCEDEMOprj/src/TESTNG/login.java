package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login {

	 WebDriver driver;
		@Test(priority = 0)
		public void preCondition()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/inventory.html");
		}

		@Test(priority = 1)
		public void loginFunctionality()
		{
			WebElement username = driver.findElement(By.id("user-name"));
			username.sendKeys("standard_user");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("secret_sauce");
			WebElement loginbtn = driver.findElement(By.id("login-button"));
			loginbtn.click();
		}
		
		@Test(priority = 2)
		public void addingtocart()
		{
			WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
	        addtocart.click();
	        WebElement addtocart1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
	        addtocart1.click();
	        WebElement addtocart2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
	        addtocart2.click();
		}
		
		@Test(priority = 3)
		public void filterfunction()
		{
			WebElement remove = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]"));
	        remove.click();
	        
	        WebElement filterbtn = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
	        filterbtn.click();
	        WebElement lowtohigh = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]"));
	        lowtohigh.click();	
		}
}
