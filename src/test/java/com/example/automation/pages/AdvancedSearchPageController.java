package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.example.automation.util.Consts;
import com.example.automation.util.IsLoaded;

public class AdvancedSearchPageController extends LoadableComponent<AdvancedSearchPageController> {

	private WebDriver webDriver;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter-marketplace\"]/ul/li[3]/label/span/a")
	private WebElement linkVintage;	
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Jewellery")
	private WebElement lnkJewellery;
	
	@FindBy(how = How.CSS, using = "#search-header > h1 > span")
	private WebElement searchResult;
	
	public AdvancedSearchPageController(WebDriver webDriver){
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@Override
	protected void load() {	
	}

	@Override
	protected void isLoaded() throws Error {
		 String url = webDriver.getCurrentUrl();	
		 System.out.println(url);
	}	
	
	public void goToVintageItemType(){
		linkVintage.click();
	}
	
	public void goToJewellerySubCategory(){
		lnkJewellery.click();
	}
	
	public String getTextSearchResults(){	
		IsLoaded.forThis(webDriver).waitUntilDisplayed(searchResult, Consts.TIMEOUT);
		return searchResult.getText();
	}
}
