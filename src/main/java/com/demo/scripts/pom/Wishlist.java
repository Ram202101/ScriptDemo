package com.demo.scripts.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Wishlist {

    private WebDriver driver;
    protected WebDriverWait webDriverWait;
    private List<WebElement> rows;
    private WebElement Wishlisttable;
    public static Integer MinProductPrice;

    public Wishlist(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    public Wishlist() {
    }

    @FindBy(xpath = "//*[@id=\"blog\"]/div[2]/div[1]/div/div/div[3]/div[3]/a")
    private WebElement wishlist;

    public void NavigatetoWishlist() {
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(wishlist));
        webElement.click();
    }

    public void GetWishlistcount() {
        Wishlisttable = driver.findElement(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/tbody"));
        rows = driver.findElements(By.tagName("tr"));
        assertEquals("Total no of product in wishlist is not equal to 4", 4, rows.size() - 1);
    }

    public int GetLowestPriceProduct() {
        List<WebElement> ProductWishlistTableHead = driver.findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/thead/tr/th"));
        ArrayList<Integer> Productprices = new ArrayList<Integer>();
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> Colvalues = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < ProductWishlistTableHead.size(); j++) {
                if (j == 3) {
                    if (Colvalues.get(j).findElement(By.tagName("ins")).isDisplayed() == true) {
                        Productprices.add(Integer.parseInt(Colvalues.get(j).findElement(By.tagName("ins")).getText().substring(1, 3)));
                    } else {
                        Productprices.add(Integer.parseInt(Colvalues.get(j).getText().substring(1, 3)));
                    }
                }
            }
        }
        MinProductPrice = Collections.min(Productprices);
        return MinProductPrice;
    }


    public void Addlowpricesproducttocart() {
        List<WebElement> ProductWishlistTableHead = driver.findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/thead/tr/th"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> Colvalues = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < ProductWishlistTableHead.size(); j++) {
                if (j == 3) {
                    Integer prodval = Integer.parseInt(Colvalues.get(j).findElement(By.tagName("ins")).getText().substring(1, 3));
                    if (prodval == MinProductPrice) {
                        Colvalues.get(5).findElement(By.tagName("a")).click();
                    }

                    if (Integer.parseInt(Colvalues.get(j).getText().substring(1, 3)) == MinProductPrice) {
                        Colvalues.get(5).findElement(By.tagName("a")).click();
                    }
                }
            }
        }
    }
}


