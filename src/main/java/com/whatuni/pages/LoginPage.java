package com.whatuni.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.whatuni.base.BasePage;
import com.whatuni.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	By loginLink= By.linkText("Sign up / Log in");
	By loginLinkInLightbox= By.linkText("Sign in");
	By emailId= By.id("loginemail");
	By password= By.id("textpwd");
    By signInButton= By.linkText("SIGN IN");
    


	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
		}
	
	public String getPageTitle() {
		
	  return elementUtil.doGetPageTitle();
	}
	
	public boolean checkSigninLink() {
		
		return elementUtil.doIsDisplayed(loginLink);
		
	}
	
	
	public HomePage doLogin(String email, String pwd){
		
		elementUtil.doClick(loginLink);
		
		elementUtil.doClick(loginLinkInLightbox);
		elementUtil.doSendkeys(emailId, email);
		WebElement password=driver.findElement(By.id("textpwd"));
		elementUtil.do_ActionsSendKeys(password, pwd);
		driver.findElement(signInButton).click();
		return new HomePage(driver);
		
		}
 
}
