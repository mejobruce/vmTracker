package com.mtm.stepdefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mtm.pages.Login;
import com.mtm.utils.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass{
	
	    Login login = new Login();
	    ReadConfig rc = new ReadConfig();
	@Given("the user is on the login page")
	public void theUserIsOnTheLoginPage() {
		
    	String url= rc.getUrl();
		driver.get(url);
		String expectedUrl = url;
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
	   
	}
	@When("the user enters valid {string} and {string}")
	public void theUserEntersvalidAnd(String userName, String pass) {
    	login.enterUsername(userName);
    	login.enterPassword(pass);
	 
	}

	@When("the user enters invalid {string} and {string}")
	public void theUserEntersInvalidAnd(String userName, String pass) {
		login.enterUsername(userName);
    	login.enterPassword(pass);
	}
	@When("clicks the login button")
	public void clicksTheLoginButton() {
		login.clickLoginButton();
	}
	@Then("the user should be logged in successfully and an {string} should be displayed")
	public void theUserShouldBeLoggedInSuccessfullyAndAnShouldBeDisplayed(String mess) {
	  
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15000))
				.pollingEvery(Duration.ofSeconds(250)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(login.SuceccMessage));
		String actual = login.SuceccMessage.getText();
		Assert.assertEquals(mess, actual);
		
	}
	@Then("an {string} should be displayed")
	public void anShouldBeDisplayed(String mess) {
		String actual = login.errorMessage1.getText();
		Assert.assertEquals(mess, actual);
	
	}



	    
	}

	

