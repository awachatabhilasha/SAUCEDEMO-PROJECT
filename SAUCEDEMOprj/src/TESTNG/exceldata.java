package TESTNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class exceldata {

	
	String [][] testdata=null;

	@DataProvider(name="details")
	public String [][] details() throws BiffException, IOException
	{
		testdata = Exceldata();
		return testdata;
	}

	public String[][] Exceldata() throws BiffException, IOException
	{
		FileInputStream excel=new FileInputStream("C:\\Users\\HP\\Desktop\\selenium classes\\Book2.xls");
		Workbook workbook=Workbook.getWorkbook(excel);
		Sheet sheet=workbook.getSheet(0);
		Sheet sheetexcel=workbook.getSheet(0);
		int row=sheetexcel.getRows();
		int column=sheetexcel.getColumns();
		System.out.println(row);
		System.out.println(column);

		String [][] value=new String[row-1][column];

		for(int i=1;i<row;i++)
		{

			for(int j=0;j<column;j++)
			{
				value[i-1][j]  = sheet.getCell(j,i).getContents(); 
			}
		}
		return value;

	}

	@Test(dataProvider = "details")
	public void username(String uname,String pwd)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		
		driver.close();
}
}