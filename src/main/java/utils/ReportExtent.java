package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author GrayCat.
 * @date 2022/01/12 10:51
 */
public class ReportExtent {
//    public static final ExtentReports extentReports = new ExtentReports();
    public static ExtentReports extent = new ExtentReports();

    public ExtentReports getExtentReports(){
        return extent;
    }


    @BeforeSuite
    public void reportInit(){
        System.out.println("执行beforesuite,初始化扩展报告");
        ExtentSparkReporter report = new ExtentSparkReporter("target/Report/Report.html");
        extent.attachReporter(report);
        extent.setSystemInfo("Auto-shinephoe","shinephoe test");
        extent.setSystemInfo("Author","graycat.");
    }

    @AfterSuite
    public void reportCreate(){
        System.out.println("执行aftersuite，创建报告");
        extent.flush();
    }

}
