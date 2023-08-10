package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.WaitUtility;

public class BTCForgotPasswordPage {

	WebDriver driver;
	
	@FindBy(xpath="//p[contains(text(), \"Please enter the email address associated with your account and We will email you a link to reset your password.\")]")
	WebElement forgotPasswordMsg;
	@FindBy(name="email")
	WebElement forgotPasswordEmail;
	@FindBy(xpath="//button[contains(text(), \"Reset Password\") and @type=\"submit\"]")
	WebElement resetPasswordSubmitButton;
	@FindBy(xpath="//a[contains(text(), \"Back\")]")
	WebElement resetPasswordBackButton;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BTCForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getForgotPasswordMsg() {
		waitutility.waitForAnElement(forgotPasswordMsg, driver);
		String forgotPasswordMsgText = forgotPasswordMsg.getText();
		return forgotPasswordMsgText;
	}
	public void enterEmailForForgotPassword(String strResetPswdEmail) {
		forgotPasswordEmail.sendKeys(strResetPswdEmail);
	}
	public void clickOnResetButton() {
		resetPasswordSubmitButton.click();
	}
	
	public BTCLoginPage forgotPassword(String strResetPswdEmail) {
		this.enterEmailForForgotPassword(strResetPswdEmail);
		//this.clickOnResetButton();
		return new BTCLoginPage(driver);
	}
	
	
}
