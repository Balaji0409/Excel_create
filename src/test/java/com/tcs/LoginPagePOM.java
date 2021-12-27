package com.tcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM extends LibGlobal{
	public LoginPagePOM() {
	
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement btnLogin;
	
	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void login(String userName,String password) {
		type(getTxtUsername(), userName);
		type(getTxtPassword(), password);
		click(getBtnLogin());
	}
		
		
		
		
		
		
		
		
		
		
		
		
}
