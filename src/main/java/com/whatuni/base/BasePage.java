package com.whatuni.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_browser(String browserName) {
		
		
		System.out.println("Browwser name is :"+ browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			if(prop.getProperty("--headless").equals("yes")) {
				ChromeOptions co=new ChromeOptions();
			co.addArguments("headless");
			driver= new ChromeDriver(co);
			}
			
			else {
				
				driver= new ChromeDriver();
			}
		}
		
		
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
			
			else {
				
				System.out.println("Browser Name"+ browserName+ "is not found, please pass the correct browser");
			}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		//driver.manage().window().fullscreen();
		//driver.get(url);
		
		return driver;
		
		}
	
	public Properties init_properties() {
		
		prop = new Properties();
		String path= "src\\main\\java\\com\\whatuni\\configurations\\config.properties";
		try {
			FileInputStream ip= new FileInputStream(path); //this is to make the connection with properties file
		    prop.load(ip);
		    //In above line one object will be created, all the properties in property file
		    //will be given to this object and the object is referred by prop
		
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("Some issue with configuration properties. Please connect your config");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return prop;
		
		
	}
	
	 
	
	
		
	}
	
	
	
	

