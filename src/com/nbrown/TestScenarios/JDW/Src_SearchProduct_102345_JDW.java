package com.nbrown.TestScenarios.JDW;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jdw.core.framework.webdriver.Driver;
import com.nbrown.TestScenarioInitialization.TestInitializationScript;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class Src_SearchProduct_102345_JDW extends TestInitializationScript
{
	{
        System.setProperty("atu.reporter.config", "C:\\Users\\SHALINI KUMARI\\workspace\\Phase1_MileStone1\\JDW\\atu.properties");
    }
	
	@Test
	public void searchProductTest()
	{
		setAuthorInfoForReports();
		sdriver.get("https://www.jdwilliams.co.uk/");
		sdriver.implicitlyWait();
		
		jdw.menuNavigation("New In", "New In | jdwilliams");
		
//		ATUReports.add("INfo Step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
