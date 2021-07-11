package com.demo.scripts.framework;

import com.demo.scripts.pom.Cart;
import com.demo.scripts.pom.Homepage;
import com.demo.scripts.pom.Wishlist;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    public Homepage homepage;
    public Wishlist wishlist;
    public Cart cart;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public Homepage getHomePage() {
        return homepage == null ? homepage = new Homepage(driver) : homepage;
    }

    public Wishlist getWishlist(){
        return wishlist == null ? wishlist= new Wishlist(driver) : wishlist;
    }

    public Cart getCart(){
        return cart == null ? cart= new Cart(driver) : cart;
    }

}
