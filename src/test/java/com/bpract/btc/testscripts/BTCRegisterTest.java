package com.bpract.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.btc.pages.BTCHomePage;
import com.bpract.btc.pages.BTCLoginPage;
import com.bpract.btc.pages.BTCRegisterPage;

public class BTCRegisterTest extends BTCTestHelper{
	BTCRegisterPage btcregisterpage;	
	BTCLoginPage btcloginpage;
	BTCHomePage btchomepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	@Test
	public void verifyRegisterationWithValidData() {
		btcloginpage = new BTCLoginPage(driver);
		btcregisterpage = btcloginpage.clickGetStarted();
		Assert.assertTrue(btcregisterpage.getSignUpMsg().contains("Sign Up"));
		Reporter.log("You are in Register Page!", true);
		btcregisterpage.register("namita@bpract.com", "12345678", "12345678", "");
		
	}
}
