package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverHelperBase extends HelperBase {
	

	protected WebDriver driver;
	private boolean acceptNextAlert = true;
	private WebDriverWait wait;

	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
		this.driver = manager.getDriver();
		wait = new WebDriverWait(driver,10);
		}
	
	public boolean isElementPresent(By by) {
	    try {
	      find(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	protected void type(By locator, String text) {
		if (text != null) {
		find(locator).clear();
		find(locator).sendKeys(text);
		}
	}

	protected void click(By locator) {
		find(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null) {
		new Select(find(locator)).selectByVisibleText(text);
		}
	}

	private WebElement find(By locator) {
		return driver.findElement(locator);
	}

}
