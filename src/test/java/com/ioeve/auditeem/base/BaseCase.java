package com.ioeve.auditeem.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 @author bgeritech
 @DESCRIPTION 
 @create 2020-01-05
*/
public class BaseCase {
    private final Logger log = LogManager.getLogger(this.getClass());

    public static AppiumDriver driver;
    public String appPackage ="tv.danmaku.bili";

    public String deviceName = "2fb7c8f2";

    public String appActivity = ".ui.splash.SplashActivity";
    public String platform = "Android";
    private AppiumServer appiumServer = new AppiumServer();


    @BeforeClass
    public void beforeClass() throws IOException {
        if(!appiumServer.checkServiceIsRunnning(4723)){
            appiumServer.startService();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("启动http://127.0.0.1:4723/wd/hub失败");
        }
    }

    @AfterClass
    public void afterClass(){
        if(driver!=null){
            log.info("driver quit ....");
            driver.quit();
        }
    }


}
