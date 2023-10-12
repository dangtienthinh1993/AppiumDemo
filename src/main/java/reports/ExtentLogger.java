package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import utils.ScreenshotUtils;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;

public class ExtentLogger {

    private ExtentLogger() {}
    
    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
//        ExtentManager.getExtentTest().fail(message);
        ExtentManager.getExtentTest().fail(message,
                createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }
}
