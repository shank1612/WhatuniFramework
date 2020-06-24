package com.whatuni.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.whatuni.base.BasePage;
import com.whatuni.pages.HomePage;
import com.whatuni.pages.LoginPage;

public class LoginPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		
		basePage= new BasePage();
        prop= basePage.init_properties();
        String browserName= prop.getProperty("browser");
        driver= basePage.init_browser(browserName);
        driver.get(prop.getProperty("url"));
        
        loginPage=new LoginPage(driver);
        
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title=loginPage.getPageTitle();
		System.out.println("login page title is :"+ title);
		Assert.assertEquals(title, "Compare the Best University Degrees Courses UK | Whatuni");
		
	}
	
@Test(priority=2)	
public void verifySignInLinkTest() {
		
		Assert.assertTrue(loginPage.checkSigninLink());
		
	}

@Test(priority=3)
public void verifyLoginTest() {
HomePage homepage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
String homeTitleAfterLogin= homepage.getPageTitle();
Assert.assertEquals(homeTitleAfterLogin, "Compare the Best University Degrees Courses UK | Whatuni");

}






@AfterTest
	public void tear() throws InterruptedException {
	    Thread.sleep(5000);
		driver.close();
	}

}
