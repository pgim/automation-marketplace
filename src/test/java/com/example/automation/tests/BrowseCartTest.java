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

import com.example.automation.pages.HomePageController;
import com.example.automation.pages.LoginPageController;
import com.example.automation.pages.TreasuryPageController;
import com.example.automation.util.Consts;

public class BrowseCartTest {

	private WebDriver webDriver;
	private HomePageController homePage;
	private LoginPageController loginPage;
	private TreasuryPageController treasuryPage;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			webDriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {			
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			webDriver = new ChromeDriver();		
		} else {
			throw new IllegalArgumentException(Consts.BROWSER_UNDEFINED);
		}		
		webDriver.manage().window().maximize();
		homePage = new HomePageController(webDriver).get();	
		loginPage = homePage.goToLoginPage().get();
		treasuryPage = new TreasuryPageController(webDriver).get();
	}

	@Test
	public void test() {
		Assert.assertEquals(true, homePage.isHeroDisplayed());
		loginPage.logIn(Consts.USERNAME, Consts.PASSWORD);			
		homePage.goToTreasuryPage();
		treasuryPage.loadFirstItem();
		Assert.assertNotNull(homePage.getLoggedInUser());
		Assert.assertEquals("Test", homePage.getLoggedInUser());		
		Assert.assertEquals(treasuryPage.isEmptyGallery(),false); 
	}

	@AfterMethod
	public void afterMethod() {
		webDriver.quit();
	}
}
