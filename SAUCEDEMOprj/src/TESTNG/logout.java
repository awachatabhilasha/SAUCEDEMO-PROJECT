package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class logout {

	private WebDriver driver;
	@Test(priority = 0)
	public void preCondition()
	{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
     driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/inventory.html");
	}
	
	
	@Test(priority = 1)
	public void logoutbtn()
	{
	WebElement username = driver.findElement(By.id("user-name"));
	username.sendKeys("standard_user");
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("secret_sauce");
	WebElement loginbtn = driver.findElement(By.id("login-button"));
	loginbtn.click();
	
	WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
	menu.click();
	
	
	
	WebElement logoutbtn = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
	//logoutbtn.click();
	Actions action = new Actions(driver);

	action.moveToElement(logoutbtn).click().perform();
	}


}