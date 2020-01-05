package com.ioeve.auditeem.po;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class LoginPage {

    @AndroidFindBy(xpath = "//*[@text='会员购']")
    public WebElement vipShop;

    @AndroidFindBy(xpath = "//*[@text='频道']")
    public WebElement videoTab;

}
