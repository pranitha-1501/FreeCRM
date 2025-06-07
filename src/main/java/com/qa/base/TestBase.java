package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

   public static WebDriver dr ;
   public static Properties pr;

public TestBase() {
    try {
        pr = new Properties();
        FileInputStream is = new FileInputStream("C:\\Users\\prudh.000\\IdeaProjects\\PRANITHA_DEMO\\src\\main\\java\\com\\qa\\config\\config.properties");
        pr.load(is);
    }
    catch(FileNotFoundException e){
        e.printStackTrace();

    }
    catch (IOException e){
        e.printStackTrace();
    }

}

public static void initialization(){
   String bname =  pr.getProperty("browser");
   if (bname.equals("chrome")){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\prudh.000\\IdeaProjects\\PRANITHA_DEMO\\chromedriver.exe");
       dr = new ChromeDriver();
   }
  else if (bname.equals("firefox")){
       System.setProperty("webdriver.gecko.driver","C:\\Users\\prudh.000\\IdeaProjects\\PRANITHA_DEMO\\geckodriver.exe");
       dr = new FirefoxDriver();
   }

    dr.manage().window().maximize();
  String url1 = pr.getProperty("url");
  dr.get(url1);

}



}
