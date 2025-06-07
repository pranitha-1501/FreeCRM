
// Author name = Pranitha Dondapati
package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testutils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    HomePage hp;
    LoginPage lp;
    ContactsPage cp;

    String sheetName = "Contacts";

    public ContactsPageTest(){
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
    public void selectname() throws InterruptedException {
    Assert.assertTrue(cp.selectname("pranitha dondapati"));
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2,dataProvider = "getTestData")
    public void createNewContact(String fName, String lName) throws InterruptedException {
        Thread.sleep(5000);
        hp.clickNewContactLink();
        cp.createContact(fName,lName);
    }

    @AfterMethod
    public void logoff(){
        dr.quit();
    }

}
