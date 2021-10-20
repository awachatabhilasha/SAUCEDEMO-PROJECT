package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class validateexcel {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		FileInputStream excel= new FileInputStream(new File("C:\\Users\\HP\\Desktop\\selenium classes\\book2.xls"));
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet=workbook.getSheet(0);
		Sheet sheetexcel=workbook.getSheet(0);

		int row=sheetexcel.getRows();
		int column=sheetexcel.getColumns();
		System.out.println(row);
		System.out.println(column);

		String [] uname=new String[20];
		String [] pwd=new String[20];
		//
		for(int i=1;i<row;i++)
		{

			for(int j=0;j<column-1;j++)
			{
				uname[i]  = sheet.getCell(j,i).getContents(); 
				pwd[i]  = sheet.getCell(j+1,i).getContents(); 
				System.out.println(i+" "+uname[i]+" "+pwd[i]);
			username(uname[i],pwd[i]);
			}
		}
	
	}
	public static void username(String uname,String pwd)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		
		driver.quit();
	}

}
