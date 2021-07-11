package com.demo.scripts.framework;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BrowserEngine {

    public WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }


    public WebDriver Initiatedriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Working\\Automation\\MyScriptDemo\\src\\Driver\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--ignore-certificate-errors");
        option.addArguments("--ignore-ssl-errors=yes");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        return driver;
    }

    public void LaunchBrowser() throws InterruptedException {
        driver.get("https://testscriptdemo.com/");
        Thread.sleep(1000);
    }

    public void GetTableRowCount(){
       List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/tbody"));
       System.out.println("row count is "+rows.size());

    }

    /*public static void main(String[] args) {
            BrowserEngine browserEngine = new BrowserEngine();
            browserEngine.Initiatedriver();
    }*/


}
