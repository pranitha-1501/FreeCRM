package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//div[text()=\"Login\"]")
    WebElement loginbutton;

    @FindBy(xpath = "//a[text()=\"Forgot your password?\"]")
    WebElement fortgotpassword;

    @FindBy(xpath = "//a[text()=\"Sign Up\"]")
    WebElement signup;


    public LoginPage(){
        PageFactory.initElements(dr,this);

    }

    public HomePage login(String username, String password1){
        email.sendKeys(username);
        password.sendKeys(password1);
        loginbutton.click();

        return new HomePage();
    }

    public ForgotpasswordPage forgotpassword(){
        fortgotpassword.click();
        return new ForgotpasswordPage();
    }

    public SignupPage signup(){
        signup.click();
        return new SignupPage();
    }
}
