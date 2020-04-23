package com.nbrown.TestScenarios.JDW;


import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.jdw.core.framework.utils.Constants;
import com.jdw.core.framework.webdriver.Driver;
import com.jdw.core.framework.webdriver.FindBy;
import com.jdw.core.framework.webdriver.SeWebDriver;
import com.jdw.core.framework.webelement.SeWebElement;
import com.nbrown.TestScenarioInitialization.TestInitializationScript;
import com.nbrown.pageobject.JDW.HomeObj_JDW;
import com.nbrown.pageobject.JDW.PLPObj_JDW;

public class Test1 extends TestInitializationScript
{
	@Test
	public void searchProduct()
	{
		WebDriver driver = Driver.getDriver();
		
		SeWebElement elm = new SeWebElement();
		
		
		
		elm.sdriver.get("https://www.jdwilliams.co.uk/");
		elm.sdriver.implicitlyWait();
		
//		WebElement w1 = sdriver.findWebElement("xpath", "//input[@name='searchString']");
//		w1.sendKeys("Jeans");
//		WebElement searchBtn = sdriver.findWebElement("id", "searchButton");
//		searchBtn.click();
		
		elm.setValue("name", HomeObj_JDW.searchTxtBox_name, "Jeans");
		elm.click("id", HomeObj_JDW.searchBtn_id);
		
		
		elm.sdriver.explicitlyWait("xpath", PLPObj_JDW.plpProduct_xpath);
		
		
	}
}
