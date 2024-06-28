package com.mtm.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.mtm.stepdefs.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
	       features = {"C:\\Users\\LENOVO\\Downloads\\VmTracker\\VmTracker\\features"},
       glue ={"com.mtm.stepdefs"},
    		   dryRun= false,
       tags= "@Login",
       monochrome=true,
    		   snippets=SnippetType.CAMELCASE,
    	        plugin = {"pretty",
             "html:target/report/cucumber.html",
             "json:target/report/cucumber.json"
     }
       )

public class CukeRunner {
	
	@AfterClass
	public static void dq()
	{
		
	}
}
