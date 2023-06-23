package com.naveenautomationlabs.AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RegisterAccount extends TestBase {
	public RegisterAccount() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement inputFirstNameTextfield;

	@FindBy(id = "input-lastname")
	private WebElement inputLastNameTextfield;

	@FindBy(id = "input-email")
	private WebElement inputEmailTextfield;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephoneTextfield;

	@FindBy(id = "input-password")
	private WebElement inputPasswordTextfield;

	@FindBy(id = "input-confirm")
	private WebElement inputConfirmPasswordTextfield;

	@FindBy(css = "(div.form-group>div.col-sm-10>label.radio-inline>input[value=\"1\"]")
	private WebElement selectNewsletterSubscribeRadioBtn;

	@FindBy(css = "div.pull-right>input:nth-of-type(1)")
	private WebElement selectPrivacyPolicyCheckbox;

	@FindBy(css = "div.pull-right>input:nth-of-type(2)")
	private WebElement registerContinueBtn;

	@FindBy(css = "div.buttons>div.pull-right>a")
	private WebElement registrationAccountcreatedcontinueBtn;

	private void enterFirstName() {
		inputFirstNameTextfield.sendKeys("testuser");
	}

	private void enterLastName() {
		inputLastNameTextfield.sendKeys("testLastName");
	}

	private void enterEmail() {
		inputEmailTextfield.sendKeys("tony@gmail.com");
	}

	private void enterTelephoneNumber() {
		inputTelephoneTextfield.sendKeys("tony@gmail.com");
	}

	private void enterPassword() {
		inputPasswordTextfield.sendKeys("Password2");
	}

	private void enterConfirmPassword() {
		inputConfirmPasswordTextfield.sendKeys("Password2");
	}

	private void selectSubscribeRadioBtn() {
		selectNewsletterSubscribeRadioBtn.click();		
	}

	private void selectPrivacyPolicy() {
		selectPrivacyPolicyCheckbox.click();
	}

	private  MyAccountHasBeenCreated clickContinueBtn() {
		selectPrivacyPolicyCheckbox.submit();
		return new MyAccountHasBeenCreated();
	}

	public  MyAccountHasBeenCreated registerPortal() {
		enterFirstName();
		enterLastName();
		enterEmail();
		enterTelephoneNumber();
		enterPassword();
		enterConfirmPassword();
		selectSubscribeRadioBtn();
		selectPrivacyPolicy();
		return clickContinueBtn();

	}
}
