package com.jdw.core.framework.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jdw.core.framework.utils.Constants;

public class SeWebDriver
{
	public WebDriver driver;
	public SeWebDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*
	 * this method is use to pass the url in the browser
	 * paramName : Browser Url
	 */
	public void get(String url)
	{
		try
		{
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement findWebElement(String locator, String locatorValue)
	{
		WebElement w1=null;
		try
		{
			w1 = driver.findElement(FindBy.getLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return w1;
	}
	
	public List<WebElement> findWebElements(String locator, String locatorValue)
	{
		List<WebElement> w1=null;
		try
		{
			w1 = driver.findElements(FindBy.getLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return w1;
	}
	
	/*
	 * Capture the title at run time  
	 */
	
	public String getPageTitle()
	{
		String title = null;
		try
		{
			title = driver.getTitle();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String getPageSource()
	{
		String source = null;
		try 
		{
			source = driver.getPageSource();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return source;
	}
	
	public String getCurrentPageUrl()
	{
		String url = null;
		try 
		{
			url = driver.getCurrentUrl();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return url;
	}
	
	public void implicitlyWait()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Constants.syncTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void explicitlyWait(String locator, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Constants.syncTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.getLocator(locator, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pageLoadWait()
	{
		try 
		{
			driver.manage().timeouts().pageLoadTimeout(Constants.syncTime, TimeUnit.SECONDS);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Select Class Methods
	
	public Select select(String locator, String locatorValue)
	{
		Select sel = null;
		try 
		{
			WebElement dropdown = findWebElement(locator, locatorValue);
			sel = new Select(dropdown);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sel;
	}
	
	public void selectByVisibleText(String locator, String locatorValue, String visibleText)
	{
		try
		{
			Select sel = select(locator, locatorValue);
			sel.selectByVisibleText(visibleText);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectByValue(String locator, String locatorValue, String value)
	{
		try
		{
			Select sel = select(locator, locatorValue);
			sel.selectByValue(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectByIndex(String locator, String locatorValue, int index)
	{
		try
		{
			Select sel = select(locator, locatorValue);
			sel.selectByIndex(index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<WebElement> getAllDropdownOptions(String locator, String locatorValue)
	{
		List<WebElement> lst = null;
		try
		{
			Select sel = select(locator, locatorValue);
			lst = sel.getOptions();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<WebElement> getAllSelectedDrpdownOptions(String locator, String locatorValue)
	{
		List<WebElement> lst = null;
		try
		{
			Select sel = select(locator, locatorValue);
			lst = sel.getAllSelectedOptions();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	public boolean isMultiple(String locator, String locatorValue)
	{
		boolean b1 = false;
		try 
		{
			Select sel = select(locator, locatorValue);
			b1 = sel.isMultiple();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return b1;
	}
	
	// Actions Classes
	
	
	public Actions getActions()
	{
		Actions act = null;
		try 
		{
			act = new Actions(driver);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return act;
	}
	
	public void moveToWebElment(String locator, String locatorValue)
	{
		try 
		{
			WebElement w1 = findWebElement(locator, locatorValue);
			Actions act = getActions();
			act.moveToElement(w1).perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void rightClick(String locator, String locatorValue)
	{
		try 
		{
			WebElement w1 = findWebElement(locator, locatorValue);
			Actions act = getActions();
			act.contextClick(w1).perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
