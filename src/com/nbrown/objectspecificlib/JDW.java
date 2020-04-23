package com.nbrown.objectspecificlib;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jdw.core.framework.webdriver.SeWebDriver;

import atu.testng.reports.ATUReports;

public class JDW
{
	public SeWebDriver sdriver;
	
	public JDW(SeWebDriver sdriver)
	{
		this.sdriver = sdriver;
	}
	
	public void menuNavigation(String menuName, String title)
	{
		try
		{
			WebElement menuWebElm = sdriver.findWebElement("xpath", "(//a[text()='"+menuName+"'])[1]");
			menuWebElm.click();
			if(title.contains(menuName))
			{
				ATUReports.add("New IN", "New In PLP", "NEW In PLP", true);
			}
			else
			{
				ATUReports.add("New IN", "New In PLP", "Not In PLP Page", false);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void subMenuNavigation(String menuName, String category, String subMenuName, String title)
	{
		try
		{
			sdriver.moveToWebElment("xpath", "(//a[text()='"+menuName+"'])[1]");
			
			WebElement w1 = sdriver.findWebElement("xpath", "(//a[text()='"+menuName+"']//following::span[text()='"+category+"']//following::a[text()='"+subMenuName+"'])[1]");
			w1.click();
			
			if(title.contains(subMenuName))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false, "It is not in PLP Page : ");
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
