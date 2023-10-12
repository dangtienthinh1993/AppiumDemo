package base;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import reports.ExtentLogger;
import utils.Driver;

import java.io.File;
import java.util.HashMap;

public class BaseTest {
    public static AppiumDriver<WebElement> driver;
    private static AppiumServiceBuilder builder;
    private static AppiumDriverLocalService service;
    private static DesiredCapabilities cap;

    @BeforeClass(alwaysRun = true)
    public static void setup() {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android_28");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        builder = new AppiumServiceBuilder().withArgument(() -> "--base-path", "/wd/hub");
        builder.withArgument(() -> "--allow-insecure","chromedriver_autodownload");
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url"})
    public static void beforeMethodSetup(String url) {
        driver = Driver.initDriver(cap);
        navigateToURL(url);
    }

    @AfterMethod(alwaysRun = true)
    public static void afterMethodTeardown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void teardown() {
        service.stop();
    }

    public static void log(String message) {
        ExtentLogger.info(message);
    }

    public static void navigateToURL(String URL) {
        driver.get(URL);
    }

}
