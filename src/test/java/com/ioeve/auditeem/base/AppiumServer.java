package com.ioeve.auditeem.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 @author bgeritech
 @DESCRIPTION 
 @create 2020-01-05
*/
public class AppiumServer {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    /**
     * 启动appium server
     */
    public void startService(){
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "true");
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    /**
     * 停止appium server
     */
    public void stopService() {
        service.stop();

    }

    /**
     * 检查appium 启动状态
     * @param port
     * @return
     */
    public boolean checkServiceIsRunnning(int port) {

        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", port));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
