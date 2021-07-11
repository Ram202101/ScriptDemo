package com.demo.scripts.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    private WebDriver driver;
    protected WebDriverWait webDriverWait;

    public Homepage(WebDriver driver){
        this.driver=driver;
        webDriverWait= new WebDriverWait(driver,30);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-310\"]/a")
    private WebElement shoplink;

    @FindBy(xpath="//*[@id=\"site-content\"]/div/div/article/ul/li[3]/div/div[2]/div/div/a")
    private WebElement firstproduct;

    @FindBy(xpath="//*[@id=\"site-content\"]/div/div/article/ul/li[4]/div/div[2]/div/div/a")
    private WebElement secondproduct;

    @FindBy(xpath="//*[@id=\"site-content\"]/div/div/article/ul/li[7]/div/div[2]/div/div/a")
    private WebElement thirdproduct;

    @FindBy(xpath="//*[@id=\"site-content\"]/div/div/article/ul/li[10]/div/div[2]/div/div/a")
    private WebElement fouthproduct;



    public void addproduct() throws InterruptedException {
        WebElement webElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(shoplink));
        webElement.click();
        Thread.sleep(1000);

        WebElement webElement01= webDriverWait.until(ExpectedConditions.elementToBeClickable(firstproduct));
        webElement01.click();
        Thread.sleep(100);

        WebElement webElement02= webDriverWait.until(ExpectedConditions.elementToBeClickable(secondproduct));
        webElement02.click();
        Thread.sleep(100);

        WebElement webElement03= webDriverWait.until(ExpectedConditions.elementToBeClickable(thirdproduct));
        webElement03.click();
        Thread.sleep(100);

        WebElement webElement04= webDriverWait.until(ExpectedConditions.elementToBeClickable(fouthproduct));
        Thread.sleep(100);
        webElement04.click();
    }

}