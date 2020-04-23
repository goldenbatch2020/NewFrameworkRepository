package com.nbrown.businessspecificlib.JDW;

import com.jdw.core.framework.datalayer.ExcelDriver;
import com.jdw.core.framework.utils.Global;
import com.jdw.core.framework.webelement.SeWebElement;
import com.nbrown.pageobject.JDW.LoginObj_JDW;

public class Login_JDW 
{
	public SeWebElement selm;
	public ExcelDriver edriver;
	public Login_JDW()
	{
		selm = new SeWebElement();
		edriver = new ExcelDriver(Global.excelSheetPath, "TestData");
		
	}
	
	public void loginToJDW()
	{
		try
		{
			String un = edriver.getData(1, 3);
			String pw = edriver.getData(1, 4);
			selm.setValue("id", LoginObj_JDW.emailTxtBox_id, un);
			selm.setValue("id", LoginObj_JDW.passwordTxtBox_id, pw);
			selm.click("name", LoginObj_JDW.signInBtn_name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
