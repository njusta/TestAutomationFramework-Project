package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	// *******Locators
	By txt_Email = By.id("email");
	By txt_Password = By.id("pass");
	By button_LogIn = By.id("loginbutton");

	// *******Constructor: initialize the webdriver. Whenever the constructor is
	// called, automatically the driver which is passed it will call this driver and
	// initialize the webdriver.
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// *******Methods
	public void enterUsername(String username) {
		driver.findElement(txt_Email).clear();
		driver.findElement(txt_Email).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_Password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(button_LogIn).click();
	}
}