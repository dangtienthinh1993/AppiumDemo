package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReport {
private static ExtentReports extent;

    public static void initReport() {
        if(Objects.isNull(ExtentManager.getExtentTest())) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Automation Report Mobile");
            spark.config().setDocumentTitle("Doc Title");
            extent.attachReporter(spark);
        }

    }

    public static void tearDownReport() {
        if(Objects.nonNull(ExtentManager.getExtentTest())) {
            extent.flush();
            ExtentManager.unload();
        }

    }

    public static void createTest(String testCaseName) {
         ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

//    public static void logInfo(String message) {
//        test.info(message);
//    }
}
