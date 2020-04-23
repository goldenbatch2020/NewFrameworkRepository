package com.nbrown.TestScenarioInitialization;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.jdw.core.framework.datalayer.ExcelDriver;
import com.jdw.core.framework.utils.Global;
import com.jdw.core.framework.webdriver.Driver;
import com.jdw.core.framework.webdriver.SeWebDriver;
import com.jdw.core.framework.webelement.SeWebElement;
import com.nbrown.businessspecificlib.JDW.Login_JDW;
import com.nbrown.businessspecificlib.JDW.PLP_JDW;
import com.nbrown.objectspecificlib.JDW;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;


public class TestInitializationScript
{
	public ExcelDriver testmgr;
	public static String packageName="com.nbrown.TestScenarios.JDW.";
	public WebDriver driver;
	public Login_JDW login;
	public SeWebDriver sdriver;
	public PLP_JDW plp;
	public JDW jdw;
	
	@BeforeClass
	public void init()
	{
		driver = Driver.getDriver();
		ATUReports.setWebDriver(driver);
		login = new Login_JDW();
		plp = new PLP_JDW();
		sdriver = new SeWebDriver(driver);
		jdw = new JDW(sdriver);
		
	}
	
			
	
	public void runtest()
	{
		testmgr = new ExcelDriver(Global.testMgrSheetPath, "TestScript_JDW");
		XmlSuite suite = new XmlSuite();
		suite.setName("SuiteName");
		
		XmlTest test = new XmlTest(suite);
		test.setName("TestRunner");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		
		ArrayList<String> keys = testmgr.getAllColData(6);
		
		for(int i=1; i<keys.size(); i++)
		{
			String key = keys.get(i);
			if(key.equals("Yes"))
			{
				String class1 = testmgr.getData(i, 4);
				String className = (packageName+class1).trim();
				classes.add(new XmlClass(className));
			}
		}
		test.setXmlClasses(classes);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		TestNG tng= new TestNG();
		
		tng.setXmlSuites(suites);
		
		tng.run();
	}
	
	public void setAuthorInfoForReports() {
		   ATUReports.setAuthorInfo("Pritam Kuamr", Utils.getCurrentTime(),"1.0");
		}
}
