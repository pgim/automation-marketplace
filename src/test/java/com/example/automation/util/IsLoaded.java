package com.example.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsLoaded {

	private final WebDriver webDriver;

	public IsLoaded(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public static IsLoaded forThis(WebDriver driver) {
		return new IsLoaded(driver);		
	}

	/**
	 * Wait until the WebElement is displayed.
	 * @param webElement
	 * @param timeout
	 */
	public void waitUntilDisplayed(final WebElement webElement, int timeout){
		(new WebDriverWait(webDriver, timeout))
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return webElement.isDisplayed();
				}
		});
	}
	
	/**
	 * Wait until the WebElement is enabled.
	 * @param webElement
	 * @param timeout
	 */
	public void waitUntilEnabled(final WebElement webElement, int timeout) {
		(new WebDriverWait(webDriver, timeout))
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return webElement.isEnabled();
				}
		});
	}
	
	/**
	 * Click when is visible and enabled.
	 * @param webElement
	 * @param timeout
	 */
	public void clickWhenIsReady(WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		element.click();
	}
}
