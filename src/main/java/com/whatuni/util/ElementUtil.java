package com.whatuni.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
	}
	
	
	public boolean waitForTitlePresent(String value) {
		 wait.until(ExpectedConditions.titleIs(value));
		 return true;
		
		
	}
	
	
	//This will apply the above explicit wait to the element until it is present
    //To call this in any class just use hod classname.method name by creating object of the class
	
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
		
	}
	
	/*This will apply the above explicit wait to the element until it is present
	To call this in any class just use hod classname.method 
	name by creating object of the class**/
	
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
		
	}
	
	
	
	public String doGetPageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			 
		//if(waitForElementPresent(locator));//This will applied globally before finding an element
			//using above is not preferred because it will be applied to all the elements which is not necessary
			element=driver.findElement(locator);
		}
		catch(Exception e){
			
			System.out.println("Some exception got occured while creating the webelemet");
		}
		
		return element;
		
	}
	
	
	public void doClick(By locator) {
		try{
		getElement(locator).click();
		}
		
		catch(Exception e) {
			System.out.println("Some Exception occured while clicking the element");
		}
	}
	
	
	
	public void doSendkeys(By locator, String value) {
		
		try {
		WebElement element=driver.findElement(locator);
		element.clear();
		element.sendKeys(value);
		}
		catch(Exception e) {
			
			System.out.println("Some Exception occured while entering values in a field");
		}
		
	}
	
	
public boolean doIsDisplayed(By locator) {
		
		
		return getElement(locator).isDisplayed();
		
}


public String doGetText(By locator) {
	
	try {
	
		return getElement(locator).getText();
	
	}
	catch(Exception e) {
		
		System.out.println("Some Exception occured while performing gettext operation");
	}
	return null;
	
}

// Action Class Send Keys

public void do_ActionsSendKeys(WebElement element, String value) {
	
	Actions action =new Actions(driver);
	action.sendKeys(element, value).build().perform();
	
}


}
