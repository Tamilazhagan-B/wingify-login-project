package com.wingify.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.wingify.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLib fl=new FileLib();
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@SuppressWarnings("deprecation")
	public static void impWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url = fl.getexcelData("UnPwdSheet", 1, 2);
		impWait();
		driver.get(url);
	}
	
	
}
