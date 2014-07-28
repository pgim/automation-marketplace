package com.example.automation.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.example.automation.pages.CartPageController;
import com.example.automation.pages.HomePageController;
import com.example.automation.pages.LoginPageController;
import com.example.automation.util.Consts;

public class BasicCartTest {

	private WebDriver webDriver;
	private HomePageController homePage;
	private LoginPageController loginPage;
	private CartPageController cartPage;		

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			webDriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {			
			File file = new File(Consts.CHROME_DRIVER);
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			webDriver = new ChromeDriver();		
		} else {
			throw new IllegalArgumentException(Consts.BROWSER_UNDEFINED);
		}	
		webDriver.manage().window().maximize();
		homePage = new HomePageController(webDriver).get();	
		loginPage = homePage.goToLoginPage().get();
		cartPage = new CartPageController(webDriver).get();
	}

	@Test
	public void scenario1() {
		loginPage.logIn(Consts.USERNAME, Consts.PASSWORD);
		if (cartPage.getCartSize() > 0 ){		
			cartPage.goToCart();
			cartPage.removeItems();
			cartPage.goToHome();
		}			
		homePage.search("hat");							
		cartPage.loadFirstItem();
		cartPage.addItem();
		cartPage.goToHome();
		Assert.assertEquals(cartPage.getCartSize(),1);		
	}
	
	@Test (dependsOnMethods = "scenario1")
	public void scenario2() {
		loginPage.logIn(Consts.USERNAME, Consts.PASSWORD);
		Assert.assertEquals(cartPage.getCartSize(),1);
		cartPage.goToCart();
		cartPage.removeItems();
		cartPage.goToHome();
		Assert.assertEquals(cartPage.getCartSize(),0);
	}

	@AfterMethod
	public void afterMethod() {
		webDriver.quit();
	}
}
