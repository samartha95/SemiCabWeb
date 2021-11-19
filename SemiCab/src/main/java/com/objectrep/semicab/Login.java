package com.objectrep.semicab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//a[text()='Sign In with Code']")
	private WebElement SignInWithCode;
	
	@FindBy(id = "codebox")
	private WebElement Codebox;
	
	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement SignIn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInWithCode() {
		return SignInWithCode;
	}

	public WebElement getCodebox() {
		return Codebox;
	}

	public WebElement getSignIn() {
		return SignIn;
	}
	
}
