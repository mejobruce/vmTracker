package com.mtm.stepdefs;

import java.awt.Robot;
import java.util.Properties;

//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;
@SuppressWarnings({"deprecation"})
public class BaseClass {
	/*******************************************************************************************************************************************************************************************************************
	   'Created By	    : Seemone mejo						
	   'Created On		: 20th May-2023				
	   'Last Updated By	: 20th May-2023		
	   'Last Updated On	: 20th May-2023		
	   'Purpose			: For driver init,classes, readConfig softAssertion object creation and others
	   '**********************************************************************************************************************************************************/
	public static  WebDriver driver;
	public static Select s;
	public static JavascriptExecutor js;
	public static TakesScreenshot tk;
	public static boolean b;
	public static Robot r;
	public static Properties properties;
	
	public static Assert verify;
	//public static Logger log;

}