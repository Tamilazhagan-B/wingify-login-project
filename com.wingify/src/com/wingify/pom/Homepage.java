package com.wingify.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wingify.generic.BaseClass;

public class Homepage extends BaseClass {
	
	
		@FindBy(id = "amount") 
		private WebElement amount;
		
		public Homepage() {
			PageFactory.initElements(driver, this);
		}
		
		public WebElement amount() {
			return amount;
			
		}
		
		
	
}
