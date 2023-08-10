package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.WaitUtility;


public class BTCLoginPage {
	WebDriver driver;
	@FindBy(name="email")
	WebElement emailidLogin;
	@FindBy(name="password")
	WebElement passwordLogin;
	@FindBy(xpath="//button[contains(text(),\"Login\") and @type=\"submit\"]")
	WebElement loginButton;
	@FindBy(xpath="//p[contains(text(), \"Email or Username is required\")]")
	WebElement blankEmailMsg;
	@FindBy(xpath="//p[contains(text(), \"Password is required\")]")
	WebElement blankPasswordMsg;
	@FindBy(xpath="//div[contains(text(), \"Wrong credentials!\")]")
	WebElement wrongCredMsg;
	@FindBy(xpath="//a[contains(text(), \"Get started\")]")
	WebElement getStartedLink;
	@FindBy(xpath="//a[contains(text(), \"Forgot password?\")]")
	WebElement forgotPasswordLink;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BTCLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String strEid) {
		emailidLogin.sendKeys(strEid);
	}
	public void enterPassword(String strPwd) {
		passwordLogin.sendKeys(strPwd);
	}
	public BTCHomePage login(String strEid, String strPwd) {
		this.enterEmailId(strEid);
		this.enterPassword(strPwd);
		loginButton.click();
		return new BTCHomePage(driver);
	}
	
	public String getBlankEmailMsg() {
		waitutility.waitForAnElement(blankEmailMsg, driver);
		String blankEmailMsgText = blankEmailMsg.getText();
		return blankEmailMsgText;
	}
	public String getBlankPasswordMsg() {
		waitutility.waitForAnElement(blankPasswordMsg, driver);
		String blankPasswordMsgText = blankPasswordMsg.getText();
		return blankPasswordMsgText;
	}
	
	public String getWrongCredMsg() {
		waitutility.waitForAnElement(wrongCredMsg, driver);
		String wrongCredMsgText = wrongCredMsg.getText();
		return wrongCredMsgText;
	}
	public BTCRegisterPage clickGetStarted() {
		getStartedLink.click();
		return new BTCRegisterPage(driver);
	}
	
	public BTCForgotPasswordPage clickForgotPassword() {
		forgotPasswordLink.click();
		return new BTCForgotPasswordPage(driver);
	}
}
