package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath="//div[@id=\"dashboard-toolbar\"]//span[text()=\"Contacts\"]")
    WebElement contactstitle;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;



public void ContactsPage(){
    PageFactory.initElements(dr,this);
}

public boolean selectname(String name) throws InterruptedException {
    Thread.sleep(5000);
    dr.findElement(By.xpath("//a[text()=\""+name+"\"]")).click();
    Thread.sleep(5000);
    return dr.findElement(By.xpath("//span[text()=\""+name+"\"]")).isDisplayed();
}

public void createContact(String fName, String lName){
    dr.findElement(By.xpath("//input[@name='first_name']")).sendKeys(fName);
    dr.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lName);
    dr.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

}


}
