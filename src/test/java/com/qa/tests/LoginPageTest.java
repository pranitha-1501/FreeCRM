// Author name = Pranitha Dondapati

package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.ForgotpasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignupPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage lp;
    HomePage hp;

    ForgotpasswordPage fp;

    SignupPage sp;

 public LoginPageTest(){
     super();

 }

 @BeforeMethod
 public void setup (){
    initialization();
     lp = new LoginPage();

    }

    @Test(priority = 1)
 public void validatelogin(){
     String email1 = pr.getProperty("email");
        String password = pr.getProperty("password");
        hp= lp.login(email1,password);
    }

    @Test(priority = 2)
    public void validateforgotpassword(){
     fp = lp.forgotpassword();
    }

    @Test(priority = 3)
    public void validatesignup(){
        sp=lp.signup();
    }

    @AfterMethod
    public void logoff(){
        dr.quit();
    }




}
