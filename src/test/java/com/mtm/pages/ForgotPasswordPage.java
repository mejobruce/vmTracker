package com.mtm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.mtm.stepdefs.BaseClass;

public class ForgotPasswordPage extends BaseClass{
	public ForgotPasswordPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	  

	    @FindBy(id = "email")
	    @CacheLookup
		public WebElement emailField;

	    @FindBy(xpath = "//button[text()='Confirm']")
	    @CacheLookup
		public WebElement submitButton;
	    
	    @FindBy(xpath = "//button[text()='Confirm']/preceding::button[text()='Cancel']")
	    @CacheLookup
		public WebElement  CancelButton;
	   
	    
	    
	    @FindBy(xpath = "//p[text()='Check your email account for reset link!']")
	    @CacheLookup
		public WebElement successMessage;

	    @FindBy(xpath = "//div[text()='Invalid email']")
	    @CacheLookup
		public WebElement errorMessage;
	   
	    @FindBy(xpath = "//button[text()='Okay']")
	    @CacheLookup
		public WebElement  OkaylButton;
	   

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }
	    public void CancelButton() {
	    	CancelButton.click();
	    }
	    public void clickSubmitButton() {
	        submitButton.click();
	    }

	    public String getSuccessMessage() {
	        return successMessage.getText();
	    }
	    public void OkaylButton() {
	    	OkaylButton.click();
	    }
	    
	    
	    
	    
	}

