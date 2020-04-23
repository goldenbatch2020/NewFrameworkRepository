package com.nbrown.businessspecificlib.JDW;

import com.jdw.core.framework.datalayer.ExcelDriver;
import com.jdw.core.framework.utils.Global;
import com.jdw.core.framework.webelement.SeWebElement;
import com.nbrown.pageobject.JDW.HomeObj_JDW;

public class PLP_JDW 
{
	public SeWebElement selm;
	public ExcelDriver edriver;
	
	public PLP_JDW()
	{
		selm = new SeWebElement();
		edriver = new ExcelDriver(Global.excelSheetPath, "TestData");
	}
	
	public void searchProduct()
	{
		try
		{
			String proDuctname= edriver.getData(2, 6);
			
			selm.setValue("name", HomeObj_JDW.searchTxtBox_name, proDuctname);
			
			selm.click("id", HomeObj_JDW.searchBtn_id);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
