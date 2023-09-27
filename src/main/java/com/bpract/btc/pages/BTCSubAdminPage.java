package com.bpract.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.btc.utilities.PageUtility;
import com.bpract.btc.utilities.WaitUtility;

public class BTCSubAdminPage {
	WebDriver driver;
	@FindBy(xpath="//h4[contains(text(), \"Sub Admins\")]")
	WebElement subAdminPageTitle;
	@FindBy(xpath="//a[contains(text(), \"Sub Admin\")]")
	WebElement subAdminCreateBtn;
	@FindBy(xpath="//h4[contains(text(), \"Add Sub Admin\")]")
	WebElement addSubAdminPageTitle;
	
	@FindBy(name="name")
	WebElement subAdminName;
	@FindBy(name="mobile")
	WebElement mobile;
	@FindBy(name="product_ids")
	WebElement product;
	@FindBy(name="department_ids")
	WebElement department;
	@FindBy(name="group_id")
	WebElement group;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	@FindBy(id="sub-admin_submit")
	WebElement submitSubAdmin;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public BTCSubAdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSubAdminPageTitle() {
		waitutility.waitForAnElement(subAdminPageTitle, driver);
		String subadminpagetitletext = subAdminPageTitle.getText();
		return subadminpagetitletext;
	}
	public void clickSubAdminCreateBtn() {
		subAdminCreateBtn.click();
	}
	public String getAddSubAdminPageTitle() {
		waitutility.waitForAnElement(addSubAdminPageTitle, driver);
		String addSubAdminPageTitleText = addSubAdminPageTitle.getText();
		return addSubAdminPageTitleText;
	}
	public void enterSubAdminName(String strSubAdminName) {
		subAdminName.sendKeys(strSubAdminName);
	}
	public void enterSubAdminMobile(String strSubAdminMobile) {
		mobile.sendKeys(strSubAdminMobile);
	}
	public void enterSubAdminProduct(String strSubAdminProduct) throws InterruptedException {
		waitutility.waitForAnElement(product, driver);
		pageutility.selectFromAutoSuggestion(product, driver, strSubAdminProduct);
	}
	public void enterSubAdminDepartment(String strSubAdminDepartment) throws InterruptedException {
		waitutility.waitForAnElement(department, driver);
		pageutility.selectFromAutoSuggestion(department, driver, strSubAdminDepartment);
	}
	public void enterSubAdminGroup(String strSubAdminGroup) throws InterruptedException {
		waitutility.waitForAnElement(group, driver);
		pageutility.selectFromAutoSuggestion(group, driver, strSubAdminGroup);
	}
	public void enterSubAdminEmail(String strSubAdminEmail) {
		email.sendKeys(strSubAdminEmail);
	}
	public void enterSubAdminUsername(String strSubAdminUsername) {
		username.sendKeys(strSubAdminUsername);
	}
	public void enterSubAdminPassword(String strSubAdminPassword) {
		password.sendKeys(strSubAdminPassword);
	}
	public void enterSubAdminConfirmPassword(String strSubAdminConfirmPassword) {
		confirmPassword.sendKeys(strSubAdminConfirmPassword);
	}
	public void clickSubmitSubAdmin() {
		submitSubAdmin.click();
	}
	public void registerSubAdmin(String strSubAdminName, String strSubAdminMobile, String strSubAdminProduct, String strSubAdminDepartment, String strSubAdminGroup, String strSubAdminEmail, String strSubAdminUsername, String strSubAdminPassword, String strSubAdminConfirmPassword) throws InterruptedException {
		this.enterSubAdminName(strSubAdminName);
		this.enterSubAdminMobile(strSubAdminMobile);
		this.enterSubAdminProduct(strSubAdminProduct);
		this.enterSubAdminDepartment(strSubAdminDepartment);
		this.enterSubAdminGroup(strSubAdminGroup);
		this.enterSubAdminEmail(strSubAdminEmail);
		this.enterSubAdminUsername(strSubAdminUsername);
		this.enterSubAdminPassword(strSubAdminPassword);
		this.enterSubAdminConfirmPassword(strSubAdminConfirmPassword);
		this.clickSubmitSubAdmin();
	}
}
