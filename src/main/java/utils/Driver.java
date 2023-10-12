package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static AppiumDriver<WebElement> driver;

    private Driver() {}
    
    public static AppiumDriver<WebElement> getWebDriver() {
        return driver;
    }

    public static AppiumDriver<WebElement> initDriver(Capabilities cap) {
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<>(url, cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception exp) {
            System.out.println("Cause is :" + exp.getCause());
            System.out.println("Message is :" + exp.getMessage());
            exp.printStackTrace();
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void quitDriver() {
        driver.quit();
    }
}
