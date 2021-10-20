package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cart {

WebDriver driver;
	
	@Test(priority = 0)
	public void testurl()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
     driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/inventory.html");
	}
	
	
	@Test(priority = 1)
	public void loginform()
	{
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		}
	
	@Test(priority = 2)
	public void addingitems()
	{
		WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
	    addtocart.click();
		WebElement cart = driver.findElement(By.className("shopping_cart_link"));
	    cart.click();
		
	}
	
	@Test(priority = 3)
	public void shopagain()
	{
		WebElement continueshopping = driver.findElement(By.id("continue-shopping"));
	    continueshopping.click();
	    
	    WebElement addtocartt = driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));
	    addtocartt.click();
		
	     WebElement cart1 = driver.findElement(By.className("shopping_cart_link"));
	    cart1.click();
	}
	
	@Test(priority = 4)
	public void checkout()
	{
		WebElement checkout = driver.findElement(By.id("checkout"));
	    checkout.click();
	    WebElement firstname = driver.findElement(By.id("first-name"));
	    firstname.sendKeys("abhilasha");
	    WebElement lastname = driver.findElement(By.id("last-name"));
	    lastname.sendKeys("bakane");
	    WebElement  zip = driver.findElement(By.id("postal-code"));
	    zip.sendKeys("411040");
	}
	
	@Test(priority = 5)
	public void lastcheckout()
	{
		WebElement continuee = driver.findElement(By.name("continue"));
	    continuee.click();
	    WebElement finish = driver.findElement(By.id("finish"));
	    finish.click();
	    WebElement backhome = driver.findElement(By.id("back-to-products"));
	    backhome.click();
	}
}
