package com.bpract.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.btc.pages.BTCHomePage;
import com.bpract.btc.pages.BTCLoginPage;
import com.bpract.btc.pages.BTCProfilePage;

public class BTCUserProfileTest extends BTCTestHelper{
	BTCLoginPage btcloginpage;
	BTCHomePage btchomepage;
	BTCProfilePage btcprofilepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@Test
	public void verifyUserIsAbleToEditInfoInProfile() {
		btcloginpage = new BTCLoginPage(driver);
		btchomepage = btcloginpage.login("sreelakshmi+1@bpract.com", "12345678");
		Assert.assertTrue(btchomepage.dashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		btcprofilepage = btchomepage.navigateToProfile();
		Assert.assertTrue(btcprofilepage.getProfileMsg().contains("Your Activity History"));
		Reporter.log("You are in My Profile Page!", true);
		btcprofilepage.navigateToEditInfo();
		btcprofilepage.editInfoUserDetails("Sreelakshmi", "Dinesh", "female", "India", "Kerala", "Calicut", "632011", "Bpract", "9876543210");
	}
	//@Test
	public void verifyUserIsAbleToUpdateProfilePicture() {
		btcloginpage = new BTCLoginPage(driver);
		btchomepage = btcloginpage.login("sreelakshmi+1@bpract.com", "12345678");
		Assert.assertTrue(btchomepage.dashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		btcprofilepage = btchomepage.navigateToProfile();
		Assert.assertTrue(btcprofilepage.getProfileMsg().contains("Your Activity History"));
		Reporter.log("You are in My Profile Page!", true);
		btcprofilepage.navigateToEditInfo();
		Assert.assertTrue(btcprofilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are in Edit Info Page!", true);
		btcprofilepage.editInfoUserPhoto("C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\cute-panda-with-coffee-cartoon-illustration-vector.jpg");
	}
	//@Test
	public void verifyIfUserIsAbleToChangePassword() {
		btcloginpage = new BTCLoginPage(driver);
		btchomepage = btcloginpage.login("sreelakshmi+1@bpract.com", "12345678");
		Assert.assertTrue(btchomepage.dashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		btcprofilepage = btchomepage.navigateToProfile();                                                                  
		
	}
}
