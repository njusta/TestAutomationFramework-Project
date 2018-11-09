package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSettingsPage {
	WebDriver driver;
	
	//*** Locators
	By dropdown_AccounSettings = By.xpath("//div[text()='Account Settings']");
	By link_LogOut = By.xpath("//text()[.='Log Out']/ancestor::span[1]");
	
	//*** Contructor
	public AccountSettingsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//*** Methods
	public void clickAccountSettings() {
		driver.findElement(dropdown_AccounSettings).click();
	}
	public void clickLogOut() {
		driver.findElement(link_LogOut).click();
	}
}
