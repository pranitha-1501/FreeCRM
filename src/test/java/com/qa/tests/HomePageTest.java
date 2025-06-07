package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage hp;
    LoginPage lp;

    ContactsPage cp;

    public HomePageTest(){
        super();

    }

    @BeforeMethod
    public void setup (){
        initialization();
        lp = new LoginPage();
        cp = new ContactsPage();
        lp.login(pr.getProperty("email"), pr.getProperty("password"));
        hp = new HomePage();

    }

    @Test(priority = 1)
    public void namedislay() throws InterruptedException {
        Assert.assertTrue(hp.validatename());
    }

    @Test(priority = 2)
    public void searchdisplay(){
        Assert.assertTrue( hp.validatesearch());
    }

    @Test(priority = 3)
    public void today1display() throws InterruptedException {
        Assert.assertTrue( hp.validatetoday());
    }

    @Test(priority = 4)
    public void validatecontactspage() throws InterruptedException {
        boolean flag= hp.navigatetocontacts();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void logoff(){
        dr.quit();
    }
}
