package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.PageUtility;
import com.bpract.btc.utilities.WaitUtility;

public class BTCAdminHomePage {
	WebDriver driver;
	@FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
	WebElement dashboardTitle;
	@FindBy(xpath="//div[contains(text(), \"Sub-Admin\")]")
	WebElement subAdminMenu;
	@FindBy(xpath="//div[contains(text(), \"Sub Admins\")]")
	WebElement subAdmin;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public BTCAdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String dashboardTitle() {
		waitutility.waitForAnElement(dashboardTitle, driver);
		String dashTitle = dashboardTitle.getText();
		return dashTitle;
	}
	public void clickSubAdminMenu() {
		pageutility.scrollToElement(subAdminMenu, driver);
		subAdminMenu.click();
		waitutility.waitForAnElement(subAdmin, driver);
		subAdmin.click();
	}
}
