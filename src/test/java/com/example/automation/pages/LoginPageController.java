package com.example.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPageController extends LoadableComponent<LoginPageController>{

	private WebDriver webDriver;
	
	@FindBy(how = How.ID, using = "sign-in-tab")
	private WebElement sign_tab;
	
	@FindBy(how = How.ID, using = "username-existing")
	private WebElement txt_userName;
	
	@FindBy(how = How.ID, using = "password-existing")
	private WebElement txt_password;
	
	@FindAll({
		@FindBy(how = How.ID, using = "signin-button"),
		@FindBy(how = How.ID, using = "signin_button")
	})
	private WebElement btn_login;
	
	
	public LoginPageController(WebDriver webDriver){
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

	public void logIn(String userName, String password){		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		txt_userName.sendKeys(userName);
        txt_password.sendKeys(password);
        btn_login.click();        
    }
}
