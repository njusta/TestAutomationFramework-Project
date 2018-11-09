package com.facebook;

import java.io.IOException;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class AccountSettingsTests extends BaseClass {
	@Test
	public void LogoutApplication() throws IOException {
		AccountSettingsPage objPage = new AccountSettingsPage(driver);
		
		objPage.clickAccountSettings();
		objPage.clickLogOut();
		
		objPage = null;
		
	}
}
