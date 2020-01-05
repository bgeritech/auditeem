package com.ioeve.auditeem.test;

import com.ioeve.auditeem.base.BaseCase;
import com.ioeve.auditeem.po.LoginPage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
 @author bgeritech
 @DESCRIPTION 
 @create 2020-01-05
*/
public class AppiumTestDemo extends BaseCase {

    private final Logger log = LogManager.getLogger(this.getClass());
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod(){
        PageFactory.initElements(new AppiumFieldDecorator(driver,new TimeOutDuration(5, TimeUnit.SECONDS)),loginPage);
    }

    @Test(description = "app-ui自动化测试demo")
    public void testDemo() {
        log.debug("Start Test...");
        String str = loginPage.videoTab.getText();
        if(str!=null){
            Assert.assertEquals("频道",str);
        }
        Assert.assertTrue(loginPage.vipShop.isDisplayed(),"检查我的tab显示");
        loginPage.vipShop.click();
        log.info("End Test...");
    }

    @AfterMethod
    public void afterMethod(){

    }


}
