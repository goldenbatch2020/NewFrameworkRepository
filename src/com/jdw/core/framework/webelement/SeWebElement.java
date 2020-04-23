package com.jdw.core.framework.webelement;


import org.openqa.selenium.WebElement;

import com.jdw.core.framework.webdriver.Driver;
import com.jdw.core.framework.webdriver.SeWebDriver;

public class SeWebElement 
{
	public SeWebDriver sdriver;
	public SeWebElement()
	{
		this.sdriver = new SeWebDriver(Driver.driver);
	}
	
	public void setValue(String locator, String locatorValue, String value)
	{
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			w1.sendKeys(value);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void click(String locator, String locatorValue)
	{
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			w1.click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void clear(String locator, String locatorValue)
	{
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			w1.clear();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean isDisplayed(String locator, String locatorValue)
	{
		boolean b1 = false;
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			b1 = w1.isDisplayed();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return b1;
	}
	
	public boolean isEnabled(String locator, String locatorValue)
	{
		boolean b1 = false;
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			b1 = w1.isEnabled();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return b1;
	}
	
	public boolean isSelected(String locator, String locatorValue)
	{
		boolean b1 = false;
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			b1 = w1.isSelected();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return b1;
	}
	
	public String captureVisibleText(String locator, String locatorValue)
	{
		String val = null;
		try 
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			val = w1.getText();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return val;
	}
	
	public String getAttribute(String locator, String locatorValue, String attributeName)
	{
		String val = null;
		
		try
		{
			WebElement w1 = sdriver.findWebElement(locator, locatorValue);
			val = w1.getAttribute(attributeName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}
}
