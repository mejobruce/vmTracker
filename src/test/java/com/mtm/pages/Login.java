package com.mtm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.mtm.stepdefs.BaseClass;

public class Login extends BaseClass{
	

	public Login() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	

	    @FindBy(id = "email")
	    @CacheLookup
		public WebElement usernameField;

	    @FindBy(id = "pass")
	    @CacheLookup
		public WebElement passwordField;

	    @FindBy(id = "loginSubmit")
	    @CacheLookup
		public WebElement loginButton;
	    
	    
	    @FindBy(xpath = "//div[text()='Register']")                
	    @CacheLookup
		public WebElement RegisterLink;
	    
	    @FindBy(xpath = "//div[text()='Forgot Password ?']")                
	    @CacheLookup
		public WebElement forgotPasswordLink;
	  
	    @FindBy(xpath = "//h3[text()='Please Enter Valid Email']")
	    @CacheLookup
		public WebElement errorMessage1;
	    
	    
	    @FindBy(xpath = "//div[text()='Succuessfully LoggedIn']")                
	    @CacheLookup
		public WebElement SuceccMessage;
	  
	    @FindBy(xpath = "//div[text()='Cannot login at the moment']")
	    @CacheLookup
		public WebElement  errorMessage2;


	    public void enterUsername(String username) {
	        usernameField.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        loginButton.click();
	    }
	    

	   
	    public void RegisterLink() {
	    	RegisterLink.click();
	    }
	    public void clickForgotPasswordLink() {
	        forgotPasswordLink.click();
	    }

	
	}



