package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[@class =\"user-display\"]")
    WebElement name;

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement search;

    @FindBy(xpath = "//div[text()=\"Today\"]")
    WebElement today1;

    @FindBy(xpath = "//a[@href=\"/contacts\"]")
    WebElement contacts;

    @FindBy(xpath = "//a[@href=\"/contacts\"]//following-sibling:: button")
    WebElement contactsplusbutton;

    @FindBy(xpath="//div[@id=\"dashboard-toolbar\"]//span[text()=\"Contacts\"]")
    WebElement contactstitle;

    @FindBy(xpath = "//button[text()=\"Create\"]")
    WebElement createnewcontatc;
public HomePage(){
    PageFactory.initElements(dr,this);

}

public boolean validatename() throws InterruptedException {
    Thread.sleep(5000);
    return name.isDisplayed();
}

public boolean validatesearch(){
   return search.isDisplayed();

}

public boolean validatetoday() throws InterruptedException {
    Thread.sleep(5000);
   return today1.isDisplayed();
}

public boolean navigatetocontacts() throws InterruptedException {
    Thread.sleep(5000);
    contacts.click();
    Thread.sleep(5000);
    return contactstitle.isDisplayed();

}

public void clickNewContactLink() throws InterruptedException {
//    Actions action = new Actions(dr);
//    action.moveToElement(contactsplusbutton).build().perform();
//    Thread.sleep(5000);
//    //contactsplusbutton.click();

    navigatetocontacts();
    createnewcontatc.click();
    Thread.sleep(5000);
}



}
