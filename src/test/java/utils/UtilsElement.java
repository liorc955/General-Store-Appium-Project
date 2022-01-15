package utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UtilsElement {
	
	protected AndroidDriver<AndroidElement> driver = null;
	
	public UtilsElement(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	protected boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	protected AndroidElement scrollToElement(String visibleText) {
	return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
			+ ".scrollable(true).instance(0))"
			+ ".scrollIntoView(new UiSelector()"
			+ ".textContains(\""+visibleText+"\")"
					+ ".instance(0))");
	}

}
