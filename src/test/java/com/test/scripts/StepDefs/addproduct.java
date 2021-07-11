package com.test.scripts.StepDefs;

import com.demo.scripts.TestContext.TestContext;
import com.demo.scripts.framework.BrowserEngine;
import com.demo.scripts.framework.PageObjectManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class addproduct {
    protected PageObjectManager pageObjectManager;

    public addproduct(TestContext testContext) {
        testContext.getDriver();
        pageObjectManager = testContext.getObjectManager();
    }

    @Given("add the first product")
    public void add_the_first_product() throws InterruptedException {
        pageObjectManager.getHomePage().addproduct();
    }
}
