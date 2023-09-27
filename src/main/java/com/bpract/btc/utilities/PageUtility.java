package com.bpract.btc.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByVisibleText(WebElement element, WebDriver driver, String str) {
		Select s = new Select(element);
		s.selectByVisibleText(str);
	}

	public void scrollToElement(WebElement element, WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void robotClassForImageUploading(String strPath) {
		  try {
			Robot rb = new Robot();
			StringSelection str = new StringSelection(strPath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void selectFromAutoSuggestion(WebElement element, WebDriver driver, String username) throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(username).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
	
}
