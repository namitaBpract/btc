package com.bpract.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.btc.pages.BTCAdminHomePage;
import com.bpract.btc.pages.BTCHomePage;
import com.bpract.btc.pages.BTCLoginPage;
import com.bpract.btc.pages.BTCSubAdminPage;
import com.bpract.btc.utilities.BTCExcelDataProvider;

public class BTCSubAdminTest extends BTCTestHelper{
	BTCLoginPage btcloginpage;
	BTCHomePage btchomepage;
	BTCAdminHomePage btcadminhomepage;
	BTCSubAdminPage btcsubadminpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@DataProvider(name="ValidSubAdminRegister")
	public Object[][]getData(){
		String excelpath = "C:\\Users\\namit\\OneDrive\\Desktop\\Namita\\Sub Admin Register.xlsx";
		BTCExcelDataProvider btcexceldataprovider = new BTCExcelDataProvider();
		Object data[][] = btcexceldataprovider.testData(excelpath, "Sheet1");
		return data;
	}
	
	@Test(dataProvider="ValidSubAdminRegister")
	public void verifyValidSubAdminRegister(String name, String mobile, String products, String departments, String group, String email, String username, String password, String confirmPassword) throws InterruptedException {
		btcloginpage = new BTCLoginPage(driver);
		btchomepage = btcloginpage.login("info@cloudlumen.com", "12345678");
		Assert.assertTrue(btchomepage.dashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		btcadminhomepage = new BTCAdminHomePage(driver);
		btcadminhomepage.clickSubAdminMenu();
		btcsubadminpage = new BTCSubAdminPage(driver);
		Assert.assertTrue(btcsubadminpage.getSubAdminPageTitle().contains("Sub Admins"));
		Reporter.log("You are in Sub Admin Page!", true);
		btcsubadminpage.clickSubAdminCreateBtn();
		Assert.assertTrue(btcsubadminpage.getAddSubAdminPageTitle().contains("Add Sub Admin"));
		Reporter.log("You are in Create Sub Admin Page!", true);
		btcsubadminpage.registerSubAdmin(name, mobile, products, departments, group, email, username, password, confirmPassword);
		Assert.assertTrue(btcsubadminpage.getSubAdminPageTitle().contains("Sub Admins"));
		Reporter.log("Back to Sub Admin Page!", true);
	}
}
