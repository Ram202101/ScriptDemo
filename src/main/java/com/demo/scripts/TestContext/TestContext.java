package com.demo.scripts.TestContext;

import com.demo.scripts.framework.BrowserEngine;
import com.demo.scripts.framework.PageObjectManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestContext extends BrowserEngine {

        protected WebDriver driver;
        private PageObjectManager pageObjectManager;

        @Before
    public void setup() throws InterruptedException {
            this.driver=Initiatedriver();
            LaunchBrowser();
            pageObjectManager = new PageObjectManager(driver);
    }

    public PageObjectManager getObjectManager() {
             return pageObjectManager;
    }

    public WebDriver getDriver() {
            return this.driver;
    }


}
