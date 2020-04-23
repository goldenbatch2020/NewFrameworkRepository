package com.nbrown.TestScenarios.JDW;

import org.testng.annotations.Test;

import com.nbrown.TestScenarioInitialization.TestInitializationScript;

public class Src_Login_10230_JDW extends TestInitializationScript
{
	@Test
	public void loinToAppTest()
	{
		sdriver.get("https://www.jdwilliams.co.uk/shop/signin/display.action");
		sdriver.implicitlyWait();
		login.loginToJDW();
		
	}
}
