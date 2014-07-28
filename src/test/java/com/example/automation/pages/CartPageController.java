package com.example.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.example.automation.util.Consts;
import com.example.automation.util.IsLoaded;

public class CartPageController extends LoadableComponent<CartPageController>{

	private WebDriver webDriver;

	@FindAll({
		@FindBy(how = How.CSS, using = "#cart_ref-count"),
		@FindBy(how = How.CSS, using = "#gnav-header > div.gnav-header-inner.clear > ul > li.cart > a > span.count")		
	})
	private WebElement count;	
	
	@FindBy(how = How.CLASS_NAME, using = "listing-thumb")
	private List<WebElement> items;
	
	@FindBy(how = How.CLASS_NAME, using = "btn-transaction ")
	private WebElement btn_addToCart;
	
	@FindBy(how = How.CLASS_NAME, using = "button-remove-quiet")
	private List<WebElement> btn_remove_item;
	
	public CartPageController(WebDriver webDriver){
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
	
	public void goToCart(){
		IsLoaded.forThis(webDriver).waitUntilDisplayed(count, Consts.TIMEOUT);
		count.click();		
	}
	
	public HomePageController goToHome(){
		return new HomePageController(webDriver);
	}
	
	public int getCartSize(){
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {		
			if (count.isEnabled()){
				return Integer.parseInt(count.getText());
			}
			return 0;
	    } catch (Exception e) {
	        return 0;
	    }
	}
	
	public void loadFirstItem(){
		IsLoaded.forThis(webDriver).clickWhenIsReady(items.get(0), Consts.TIMEOUT);
	}
	
	public void addItem(){
		IsLoaded.forThis(webDriver).clickWhenIsReady(btn_addToCart, Consts.TIMEOUT);
	}
	
	public void removeItems(){		
		for (WebElement element : btn_remove_item){				
			element.click();
		}
	}	
}
