package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.example.automation.util.Consts;
import com.example.automation.util.IsLoaded;

public class HomePageController extends LoadableComponent<HomePageController>{

	private WebDriver webDriver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='hero']")
	private WebElement hero;
	
	@FindBy(how = How.ID, using = "sign-in")
	private WebElement lnkLogin;	

	@FindBy(how = How.CLASS_NAME, using = "profile-link")
	private WebElement lnkProfile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"treasury\"]/a")
	private WebElement lnkGallery;
		
	@FindAll({
		@FindBy(how = How.CSS, using = "#search-bar > div"),
		@FindBy(how = How.CSS, using = "#gnav-search > div")
	})
	private WebElement searchBar;	
		
	@FindBy(how = How.ID, using = "search-query")
	private WebElement txtSearch;

	@FindAll({
		@FindBy(how = How.ID, using = "search_submit"),
		@FindBy(how = How.CSS, using = "#gnav-search > div > div.search-button-wrapper.hide > button")
	})
	private WebElement btnSearch;
	
	public HomePageController(WebDriver webDriver){
		this.webDriver = webDriver;				
		PageFactory.initElements(webDriver, this);
	}
	
	@Override
	protected void load() {		
		webDriver.get("http://www.etsy.com");
	}

	@Override
	  protected void isLoaded() throws Error {		
	    String url = webDriver.getCurrentUrl();	   
	    System.out.println(url);
	    Assert.assertTrue(url.equalsIgnoreCase("https://www.etsy.com/"));
	}			
	
	public void search(String search){
		IsLoaded.forThis(webDriver).waitUntilDisplayed(btnSearch, Consts.TIMEOUT);
		txtSearch.sendKeys(search);
		btnSearch.click();
	}
	
	public boolean isHeroDisplayed(){	
		IsLoaded.forThis(webDriver).waitUntilDisplayed(hero, Consts.TIMEOUT);
		return hero.isDisplayed();
	}
	
	public LoginPageController goToLoginPage(){		 
		IsLoaded.forThis(webDriver).clickWhenIsReady(lnkLogin, Consts.TIMEOUT);
		return new LoginPageController(webDriver);
	}
	
	public TreasuryPageController goToTreasuryPage(){
		IsLoaded.forThis(webDriver).clickWhenIsReady(lnkGallery, Consts.TIMEOUT);
		return new TreasuryPageController(webDriver);
	}	
			
	public String getLoggedInUser(){
		IsLoaded.forThis(webDriver).waitUntilDisplayed(lnkProfile, Consts.TIMEOUT);
		return lnkProfile.getText();
	}
}
