package com.mtm.stepdefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mtm.pages.Login;
import com.mtm.pages.RegistrationPage;
import com.mtm.utils.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends BaseClass {
	
	Login login = new Login();
	    RegistrationPage registrationPage = new RegistrationPage();
	    ReadConfig rc = new ReadConfig();

	@Given("the user is on the registration page")
	public void theUserIsOnTheRegistrationPage() {
    	String url= rc.getUrl();
		driver.get(url);
		login.RegisterLink();
		
	}

	@When("the user enters valid registration details {string},{string},{string},{string}")
	public void theUserEntersValidRegistrationDetails(String name, String email, String phone, String pass) {
		 registrationPage.Name(name);
		 registrationPage.enterEmail(email);
		 registrationPage.phoneNumber(phone);
		 registrationPage.enterPassword(pass);
		
	}
	@When("clicks the register button")
	public void clicksTheRegisterButton() {
		registrationPage.clickRegisterButton();
	}
	@Then("a {string} should be displayed")
	public void aShouldBeDisplayed(String mess) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15000))
				.pollingEvery(Duration.ofSeconds(250)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(registrationPage.successMessage));
		String actual = registrationPage.successMessage.getText();
		Assert.assertEquals(mess, actual);
		
		
	}  
	@When("the user enters incomplete registration details {string},{string},{string},{string}")
	public void theUserEntersIncompleteRegistrationDetails(String name, String email, String phone, String pass) {
	   
		registrationPage.Name(name);
		 registrationPage.enterEmail(email);
		 registrationPage.phoneNumber(phone);
		 registrationPage.enterPassword(pass);
	}

	@Then("an error message should be displayed")
	public void anErrorMessageShouldBeDisplayed() {
		String name = "Please Enter Name";
		Assert.assertEquals(name, registrationPage.nameErrorMessage.getText());	
		String email ="Please Enter Valid Email";
		Assert.assertEquals( email, registrationPage.emailErrorMessage.getText());
		String phone = "Please Enter Phone";
		Assert.assertEquals( phone,registrationPage.numberErrorMessage.getText());	
		String pass = "Please Enter Password";
		Assert.assertEquals(pass,registrationPage.passErrorMessage.getText());
		
	}	    
	    
	}

	
	


