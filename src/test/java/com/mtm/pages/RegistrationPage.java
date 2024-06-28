package com.mtm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.mtm.stepdefs.BaseClass;

public class RegistrationPage extends BaseClass{
	public RegistrationPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}


	    @FindBy(id = "Name")
	    @CacheLookup
		public WebElement Name;

	    @FindBy(id = "email")
	    @CacheLookup
		public WebElement emailField;
	    
	    @FindBy(className = "PhoneInputInput")
	    @CacheLookup
		public WebElement phoneNumber;

	    @FindBy(id = "password")
	    @CacheLookup
		public WebElement passwordField;

	    @FindBy(id = "registerSubmit")
	    @CacheLookup
		public WebElement registerButton;

	    @FindBy(xpath = "//div[text()='Succuessfully Registered']")
	    @CacheLookup
		public WebElement successMessage;

	    @FindBy(xpath= "//h3[text()='Please Enter Name']")
	    @CacheLookup
		public WebElement nameErrorMessage;       //div[text='User mobile or email already exists']
	    
	    @FindBy(xpath= "//h3[text()='Please Enter Valid Email']")
	    @CacheLookup
		public WebElement emailErrorMessage; 
	    @FindBy(xpath= "//h3[text()='Please Enter Phone']")
	    @CacheLookup
		public WebElement numberErrorMessage; 
	    @FindBy(xpath= "//h3[text()='Please Enter Password']")
	    @CacheLookup
		public WebElement passErrorMessage; 
	    
	    

	    public void Name(String name) {
	        Name.sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }
	    
	    public void phoneNumber(String number) {
	    	phoneNumber.sendKeys(number);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickRegisterButton() {
	        registerButton.click();
	    }

	  

	    
	}
	
	
	
	
	
	
	
	
	
	

