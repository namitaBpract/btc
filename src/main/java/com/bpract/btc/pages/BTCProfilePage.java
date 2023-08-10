package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bpract.btc.utilities.PageUtility;
import com.bpract.btc.utilities.WaitUtility;

public class BTCProfilePage {
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(), \"Profile\")]")
	WebElement profile;
	@FindBy(xpath="//h6[contains(text(),\"Your Activity History\")]")
	WebElement yourActivityHistoryProfileMsg;
	@FindBy(xpath="//button[contains(text(), \"Edit Info\")]")
	WebElement editInfo;
	@FindBy(xpath="//h6[contains(text(),\"Social Media Scope\")]")
	WebElement editInfoPageMsg;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/main/div[2]/div/div[2]/div[2]/div/div[3]/div/button[3]")
	WebElement settings;
	@FindBy(xpath="//h6[contains(text(), \"Account Settings\")]")
	WebElement settingsPageMsg;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="gender")
	WebElement gender;
	@FindBy(name="country")
	WebElement country;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="zipcode")
	WebElement zipcode;
	@FindBy(name="address")
	WebElement address;
	@FindBy(name="mobile")
	WebElement phoneNumber;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Save Changes\")]")
	WebElement saveChanges;
	@FindBy(xpath="//div[@class=\"css-soonpg\"]")
	WebElement uploadPhoto;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility(); 
	
	public BTCProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getProfileMsg() {
		waitutility.waitForAnElement(yourActivityHistoryProfileMsg, driver);
		String profileMsgText = yourActivityHistoryProfileMsg.getText();
		return profileMsgText;
	}
	public void navigateToEditInfo() {
		waitutility.waitForAnElement(editInfo, driver);
		editInfo.click();
	}
	public String getEditInfoPageMsg() {
		waitutility.waitForAnElement(editInfoPageMsg, driver);
		String editInfoPageMsgText = editInfoPageMsg.getText();
		return editInfoPageMsgText;
	}
	
	public void enterFirstName(String strFname) {
		waitutility.waitForAnElement(firstName, driver);
		firstName.sendKeys(strFname);
	}
	public void enterLastName(String strLname) {
		lastName.sendKeys(strLname);
	}
	public void selectGender(String strGender) {
		pageutility.selectByVisibleText(gender, driver, strGender); 
	}
	
//	public void selectCountry(String strCountry) {
//		Select s = new Select(country);
//		s.selectByVisibleText(strCountry);
//	}
	
	public void selectCountry(String strCountry) {
		pageutility.selectByVisibleText(country, driver, strCountry);
	}
	public void enterState(String strState) {
		state.sendKeys(strState);
	}
	public void enterCity(String strCity) {
		city.sendKeys(strCity);
	}
	public void enterZipCode(String strZipCode) {
		zipcode.sendKeys(strZipCode);
	}
	public void enterAddress(String strAddress) {
		address.sendKeys(strAddress);
	}
	public void enterPhoneNumber(String strPhoneNumber) {
		phoneNumber.sendKeys(strPhoneNumber);
	}
	public void clickSaveChanges() {
		saveChanges.click();
	}
	public void editInfoUserDetails(String strFname, String strLname, String strGender, String strCountry, String strState, String strCity, String strZipCode, String strAddress, String strPhoneNumber) {
		this.enterFirstName(strFname);
		this.enterLastName(strLname);
		this.selectGender(strGender);
		this.selectCountry(strCountry);
		this.enterState(strState);
		this.enterCity(strCity);
		this.enterZipCode(strZipCode);
		this.enterAddress(strAddress);
		this.enterPhoneNumber(strPhoneNumber);
		this.clickSaveChanges();
	}
	
	public void scrollToProfilePicture() {
		pageutility.scrollToElement(uploadPhoto, driver);
	}
	public void clickOnUploadPhoto(String strPath) {
		uploadPhoto.sendKeys(strPath);
	}
	public void editInfoUserPhoto(String strPath) {
		this.scrollToProfilePicture();
		this.clickOnUploadPhoto(strPath);
	}
	
	
	public void navigateToSettings() {
		waitutility.waitForAnElement(settings, driver);
		settings.click();
	}
	public String getSettingsPageMsg() {
		waitutility.waitForAnElement(settingsPageMsg, driver);
		String settingsPageMsgText = settingsPageMsg.getText();
		return settingsPageMsgText;
	}
}
