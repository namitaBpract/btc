package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.WaitUtility;

public class BTCRegisterPage {
	WebDriver driver;
	
	@FindBy(xpath="//h4[contains(text(), \"Sign Up\")]")
	WebElement signUpPageMsg;
	@FindBy(name="email")
	WebElement emailId;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="repassword")
	WebElement reEnterPassword;
	@FindBy(name="referral")
	WebElement referralID;
	@FindBy(name="agree")
	WebElement iAgreeCheckBox;
	@FindBy(id="recaptcha-anchor")
	WebElement captchaCheckBox;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Register\")]")
	WebElement registerButton;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BTCRegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getSignUpMsg() {
		waitutility.waitForAnElement(signUpPageMsg, driver);
		String signUpMsgText = signUpPageMsg.getText();
		return signUpMsgText;
	}
	public void enterEmailId(String strEid) {
		emailId.sendKeys(strEid);
	}
	public void enterPassword(String strPswd) {
		password.sendKeys(strPswd);
	}
	public void renterPassword(String strRePswd) {
		reEnterPassword.sendKeys(strRePswd);
	}
	public void enterReferralId(String strRefferalId) {
		referralID.sendKeys(strRefferalId);
	}
	public void clickRegister() {
		registerButton.click();
	}
	public void clickIAgree() {
		iAgreeCheckBox.click();
	}
	public void clickCaptcha() {
		captchaCheckBox.click();
	}
	public BTCHomePage register(String strEid, String strPswd, String strRePswd, String strRefferalId) {
		this.enterEmailId(strEid);
		this.enterPassword(strPswd);
		this.renterPassword(strRePswd);
		this.enterReferralId(strRefferalId);
		this.clickIAgree();
		this.clickCaptcha();
		this.clickRegister();
		return new BTCHomePage(driver);
	}
}
