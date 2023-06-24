package com.wingify.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wingify.generic.BaseClass;
import com.wingify.generic.FileLib;
import com.wingify.pom.LoginPage;

public class LoginSecnario extends BaseClass{
	FileLib fl=new FileLib();
	public static void priviousPage() {
		driver.navigate().back();
	}
	
	public static void removeUnPwdTF(LoginPage l) {
		l.userName().clear();
		  l.passWord().clear();
	}
	
	@Test
	public void validUnPwd() throws EncryptedDocumentException, IOException {
		String un = fl.getexcelData("UnPwdSheet", 1, 0);
		String pwd = fl.getexcelData("UnPwdSheet", 1, 1);
		LoginPage l=new LoginPage(driver);
		impWait();
		l.userName().sendKeys(un);
		l.passWord().sendKeys(pwd);
		l.logIn().click();
		Reporter.log("It's logined using valid username and password",true);
		priviousPage();
	}
	
	
	  @Test(priority = 1) public void emptyUN_Pwd(){ 
	  LoginPage l=new LoginPage(driver);
	  removeUnPwdTF(l);
	  
	  l.logIn().click(); 
	  String error = l.errorMsg().getText(); 
	  SoftAssert sa=new SoftAssert(); 
	  sa.assertEquals(error,"Both Username and Password must be present");
	  Reporter.log("with a empty username and password test field it couldn't login",true);
	  sa.assertAll(); 
	  }
	 
	
	
	
	  @Test(priority = 2) 
	   public void validUN_wrongPass() throws EncryptedDocumentException, IOException { 
		  LoginPage l=new LoginPage(driver);
		  String un = fl.getexcelData("UnPwdSheet", 2, 0);
		  removeUnPwdTF(l); 
		  String pwd =fl.getexcelData("UnPwdSheet", 2, 1); 
		  impWait(); 
		  l.userName().sendKeys(un);
		  l.passWord().sendKeys(pwd);
		  impWait();
		  l.logIn().click();
		  Reporter.log("checked for valid username and wrong password",true);
		  priviousPage();
	  }
	  
	  @Test(priority = 3) 
	   public void wromgUN_validPass() throws EncryptedDocumentException, IOException { 
		  LoginPage l=new LoginPage(driver);
		  String un = fl.getexcelData("UnPwdSheet", 3, 0); 
		  String pwd =fl.getexcelData("UnPwdSheet", 3, 1); 
		  removeUnPwdTF(l);
		  impWait(); 
		  l.userName().sendKeys(un);
		  l.passWord().sendKeys(pwd);
		  impWait();
		  l.logIn().click();
		  Reporter.log("checked for wrong username and valid password",true);
		  priviousPage();
	  }
	  
	  
	  
	
	
	
	
	
	
	
	
}
