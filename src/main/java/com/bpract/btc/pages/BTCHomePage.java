package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.WaitUtility;

public class BTCHomePage {
	WebDriver driver;
	@FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
	WebElement dashboardTitle;
	@FindBy(xpath="//div[contains(text(),\"My Profile\")]")
	WebElement myProfile;
	@FindBy(xpath="//button[contains(text(),\"Skip\")]")
	WebElement skipButton;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BTCHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickSkip() {
		waitutility.waitForAnElement(skipButton, driver);
		skipButton.click();
	}
	public String dashboardTitle() {
		waitutility.waitForAnElement(dashboardTitle, driver);
		String dashTitle = dashboardTitle.getText();
		return dashTitle;
	}
	public void clickMyProfile() {
		waitutility.waitForAnElement(myProfile, driver);
		myProfile.click();
	}
	
	public BTCProfilePage navigateToProfile() {
		this.clickSkip();
		this.clickMyProfile();
		return new BTCProfilePage(driver);
	}
	
}
