package com.bpract.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.btc.pages.BTCForgotPasswordPage;
import com.bpract.btc.pages.BTCHomePage;
import com.bpract.btc.pages.BTCLoginPage;

public class BTCLoginTest extends BTCTestHelper{
	BTCLoginPage btcloginpage;
	BTCHomePage btchomepage;
	BTCForgotPasswordPage btcforgotpasswordpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@Test
	public void verifyLoginWithValidData() {
		btcloginpage = new BTCLoginPage(driver);
		btchomepage = btcloginpage.login("sreelakshmi@bpract.com", "12345678");
		btchomepage.clickSkip();
		Assert.assertTrue(btchomepage.dashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
	}
	//@Test
	public void verifyUserLoginWithBlankEmailPassword() {
		btcloginpage = new BTCLoginPage(driver);
		btcloginpage.login("", "");
		Assert.assertTrue(btcloginpage.getBlankEmailMsg().contains("Email or Username is required"));
		Reporter.log("Email ID field is blank!!!", true);
		Assert.assertTrue(btcloginpage.getBlankPasswordMsg().contains("Password is required"));
		Reporter.log("Password field is blank!!!", true);
	}
	//@Test
	public void verifyUserLoginWithInvalidData() {
		btcloginpage = new BTCLoginPage(driver);
		btcloginpage.login("namita@bpract.com", "12345678");
		Assert.assertTrue(btcloginpage.getWrongCredMsg().contains("Wrong credentials!"));
		Reporter.log("Entered credentials are wrong!!!", true);
	}
	//@Test
	public void verifyForgotPassword() {
		btcloginpage = new BTCLoginPage(driver);
		btcforgotpasswordpage = btcloginpage.clickForgotPassword();
		Assert.assertTrue(btcforgotpasswordpage.getForgotPasswordMsg().contains("Please enter the email address associated with your account and We will email you a link to reset your password."));
		Reporter.log("Forgot Password Page!!!", true);
		btcforgotpasswordpage.forgotPassword("namita@gmail.com");
	}
}
