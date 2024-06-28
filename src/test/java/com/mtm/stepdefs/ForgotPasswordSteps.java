package com.mtm.stepdefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mtm.pages.ForgotPasswordPage;
import com.mtm.pages.Login;
import com.mtm.utils.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps extends BaseClass {
	Login login = new Login();
	 ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	 ReadConfig rc = new ReadConfig();
	@Given("the user is on the forgot password page")
	public void theUserIsOnTheForgotPasswordPage() {
		String url= rc.getUrl();
		driver.get(url);
		login.clickForgotPasswordLink();;
		
	}


	

	@When("the user enters a valid {string} address")
	public void theUserEntersAValidAddress(String email) {
		forgotPasswordPage.enterEmail(email);
	    
		
	}
	

@When("the user enters an invalid {string} address")
public void theUserEntersAnInvalidAddress(String email) {
	forgotPasswordPage.enterEmail(email);
    
}
	@When("clicks the submit button")
	public void clicksTheSubmitButton() {
		forgotPasswordPage.clickSubmitButton();
	}
	
	@Then("a {string} will then be shown.")
	public void aWillThenBeShown(String mess) {
		Assert.assertEquals(mess, forgotPasswordPage.getSuccessMessage());
	}

	@Then("The user should see an {string}.")
	public void theUserShouldSeeAn(String mess) {
		forgotPasswordPage.CancelButton();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15000))
				.pollingEvery(Duration.ofSeconds(250)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.errorMessage));
		String actual = forgotPasswordPage.errorMessage.getText();
		Assert.assertEquals(mess, actual);
	}
	
	
}
