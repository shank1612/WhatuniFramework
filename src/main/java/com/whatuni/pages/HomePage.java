package com.whatuni.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.whatuni.base.BasePage;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	By welcomeHeader= By.cssSelector("h2.row-fluid txt_cnr fl fnt_lbk");
	
	
public HomePage(WebDriver driver){
		
	this.driver=driver;
		
		}


public String getPageTitle() {
	
	  return driver.getTitle();
	}

public String getHomePageTitle() {
	
	return driver.getTitle();
	


	
	 
	
	
}
	
	
	

}
