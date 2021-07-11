package com.demo.scripts.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.demo.scripts.pom.Wishlist.*;
import static org.junit.Assert.assertEquals;

public class Cart {

    private WebDriver driver;
    protected WebDriverWait webDriverWait;

    public Cart(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//*[@id=\"blog\"]/div[1]/div[1]/div/div/div[3]/div[1]/div/div/a/i")
    private WebElement Cart;


    public void validatecartitems() throws InterruptedException {
        Thread.sleep(100);
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(Cart));
        Thread.sleep(100);
        element.click();

        WebElement Carttable = driver.findElement(By.xpath("//*[@id=\"site-content\"]/div/div/article/div/div/div[1]/div/form/table"));
        List<WebElement> cartrows = driver.findElements(By.tagName("tr"));

        List<WebElement> CarTableHead = driver.findElements(By.xpath("//*[@id=\"site-content\"]/div/div/article/div/div/div[1]/div/form/table/thead/tr/th"));
        for (int i = 1; i < cartrows.size(); i++) {
            List<WebElement> Colvalues = cartrows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < CarTableHead.size(); j++) {
                if (CarTableHead.get(j).getText() == "Price") {
                    assertEquals("Product price in cart is lowest", Colvalues.get(j).getText().substring(1, 3), MinProductPrice.toString());
                }
            }
        }
    }
}





