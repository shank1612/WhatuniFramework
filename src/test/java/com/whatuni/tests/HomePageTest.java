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

public class HomePageTest {
	
	
	public class LoginPageTest {
		
		BasePage basePage;
		Properties prop;
		WebDriver driver;
		LoginPage loginPage;
		HomePage homePage;
		
		@BeforeTest
		public void setUp() {
			
			basePage= new BasePage();
	        prop= basePage.init_properties();
	        String browserName= prop.getProperty("browser");
	        driver= basePage.init_browser(browserName);
	        driver.get(prop.getProperty("url"));
	        loginPage=new LoginPage(driver);
	       homePage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	        
		}
		
		
		@Test(enabled=false)
		public void verifyHomePageHeader1() {
			
			String title=homePage.getHomePageTitle();
			System.out.println(title);
			Assert.assertTrue(title.contains("nice to see you again!"));
			
			
		}
		
		@Test
		public void verifyHomePageTitle() throws InterruptedException {
			Thread.sleep(5000);
			String title=homePage.getHomePageTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Compare the Best University Degrees Courses UK | Whatuni");
			
			
		}
		
		
		
		
		
		
		
		
		@AfterTest
		public void tear() throws InterruptedException {
		    driver.close();
		}
		
		
		

}
}