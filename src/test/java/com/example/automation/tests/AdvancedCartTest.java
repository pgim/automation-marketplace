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

import com.example.automation.pages.AdvancedSearchPageController;
import com.example.automation.pages.HomePageController;
import com.example.automation.pages.LoginPageController;
import com.example.automation.util.Consts;

public class AdvancedCartTest {

	private WebDriver webDriver;
	private HomePageController homePage;
	private LoginPageController loginPage;
	private AdvancedSearchPageController advancedSearchPageController;		

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
		advancedSearchPageController = new AdvancedSearchPageController(webDriver).get();
	}

	@Test
	public void scenario1() {
		loginPage.logIn(Consts.USERNAME, Consts.PASSWORD);	
		homePage.search("hat");
		advancedSearchPageController.goToVintageItemType();
		Assert.assertEquals(advancedSearchPageController.getTextSearchResults().startsWith("We found"),true);
	}
		
	@Test
	public void scenario2() {
		loginPage.logIn(Consts.USERNAME, Consts.PASSWORD);		
		homePage.search("ring");
		advancedSearchPageController.goToVintageItemType();
		advancedSearchPageController.goToJewellerySubCategory();
		Assert.assertEquals(advancedSearchPageController.getTextSearchResults().startsWith("We found"),true);		
	}

	@AfterMethod
	public void afterMethod() {
		webDriver.quit();
	}
}
