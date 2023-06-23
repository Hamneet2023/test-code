package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;
import com.naveenautomationlabs.AutomationFramework.pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.pages.MyAccountHasBeenCreated;
import com.naveenautomationlabs.AutomationFramework.pages.RegisterAccount;
import com.naveenautomationlabs.AutomationFramework.pages.YourStore;

public class MyAccountTest extends TestBase {
	YourStore yourStore;
	RegisterAccount registerAccount;
	MyAccountHasBeenCreated myAccountCreated;
	MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		intialisation();
		registerAccount=new RegisterAccount();
		//yourStore = new YourStore();
	}

	@Test
	public void validateLoginUsingValidCredentials() {
		myAccountCreated=registerAccount.registerPortal();
		myAccountCreated.accountHasBeenCreatedGetText();
		Assert.assertEquals(myAccountCreated.accountHasBeenCreatedGetText(), "Your Account Has Been Created!");
		//myAccount.getMyAccountText();
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}