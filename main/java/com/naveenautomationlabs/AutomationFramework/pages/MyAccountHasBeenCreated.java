package com.naveenautomationlabs.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccountHasBeenCreated extends TestBase {
	public MyAccountHasBeenCreated() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h1")
	private WebElement accountHasbeenCreatedSuccessMessage;

	@FindBy(css = "div.buttons>div.pull-right>a")
	private WebElement registrationAccountcreatedcontinueBtn;

	public String accountHasBeenCreatedGetText() {
		return accountHasbeenCreatedSuccessMessage.getText();
	}

	public MyAccount continueBtnAfterAccountCreated() {
		registrationAccountcreatedcontinueBtn.click();
		return new MyAccount();
	}
}
