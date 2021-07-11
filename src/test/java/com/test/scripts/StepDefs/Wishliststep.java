package com.test.scripts.StepDefs;

import com.demo.scripts.TestContext.TestContext;
import com.demo.scripts.framework.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wishliststep {

    private PageObjectManager pageObjectManager;

    public Wishliststep(TestContext testContext){
        testContext.getDriver();
        pageObjectManager=testContext.getObjectManager();
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() {
       pageObjectManager.getWishlist().NavigatetoWishlist();
    }


    @Then("I find total four selected items in my Wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() {
        pageObjectManager.getWishlist().GetWishlistcount();
    }

    @When("I search for lowest price product")
    public void i_search_for_lowest_price_product() {
        pageObjectManager.getWishlist().GetLowestPriceProduct();
    }
    @When("I am able to add the lowest price item to my cart")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
     pageObjectManager.getWishlist().Addlowpricesproducttocart();
    }

}
