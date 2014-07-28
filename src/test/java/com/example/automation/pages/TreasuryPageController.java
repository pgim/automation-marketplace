package com.example.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class TreasuryPageController extends
		LoadableComponent<TreasuryPageController> {

	private WebDriver webDriver;

	@FindBy(how = How.CLASS_NAME, using = "item-treasury-info-box")
	private List<WebElement> items;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/ul/li[1]/div[2]/div[2]/h3/a")
	private WebElement lnk_firstItem;

	@FindBy(how = How.CLASS_NAME, using = "listing-card")
	private List<WebElement> list;

	public TreasuryPageController(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void isLoaded() throws Error {
		String url = webDriver.getCurrentUrl();
		System.out.println(url);
	}

	public void loadFirstItem() {		
		lnk_firstItem.click();
	}

	public boolean isEmptyGallery() {
		return list.isEmpty();
	}
}
