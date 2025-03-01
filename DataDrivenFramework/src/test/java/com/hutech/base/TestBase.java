package com.hutech.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties config=new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");//it should be org.apache.logger(String)
	
	
	
	
	
	@BeforeSuite
	public void setUp()
	{
		if(driver==null)
		{
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			if(config.getProperty("browser").equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
			}else if(config.getProperty("browser").equals("firefox"))
			{
				driver=new FirefoxDriver();
			}else
			{
				driver=new EdgeDriver();
			}
			
			driver.get(config.getProperty("url"));
			driver.manage().window().maximize();
			
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
		
		driver.quit();
	}
	}
	
	
	
	public static String screenshotName;
	public static void CaptureScreenshot() throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		screenshotName=d.toString().replace(":","_").replace(" ","_")+".jpg";
		
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName));
			
		
	}

}
