package testCase;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.PilePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author GrayCat.
 * @date 2022/01/12 11:09
 */
public class BaseCase {
    public AppiumDriver appiumDriver;
    public LoginPage loginPage;
    public HomePage homePage;
    public PilePage pilePage;

    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @BeforeClass
    public void classLevelSetup() throws MalformedURLException {
        System.out.println("执行beforeclass");
        //打包DesiredCapabilities这个类
        DesiredCapabilities des2 = new DesiredCapabilities();
        // 使用automator2才能检索toast弹窗
        des2.setCapability("automationName","UiAutomator2");
        // 指定测试平台
        des2.setCapability("sessionOverride", true);
        des2.setCapability("platformName", "Android");
        des2.setCapability("platformVersion", "7.1.2");
        //指定测试机id,通过adb命令(adb devices)获取
        des2.setCapability("deviceName", "device");  // 逍遥模拟器
        des2.setCapability("noReset", true);

        //获取包名及第一个页面的activity
        // project ev
        des2.setCapability("appPackage","com.growatt.chargingpile");
        des2.setCapability("appActivity","com.growatt.chargingpile.activity.LoginActivity");
//        // shinephone
//        des2.setCapability("appPackage", "com.growatt.shinephone");
//        des2.setCapability("appActivity", "com.growatt.shinephone.activity.LoginActivity");

        // 连接appium服务
        appiumDriver = new AppiumDriver(new URL("http://20.60.5.100:4723/wd/hub"), des2);
        // 隐式等待
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod   // 每个methed方法之前运行一次
    public void methodLevelSetup() {
        System.out.println("执行before method");
        loginPage = new LoginPage(appiumDriver);
        homePage = new HomePage(appiumDriver);
        pilePage = new PilePage(appiumDriver);
    }

    @BeforeGroups(groups = "login",enabled = false)
    public void init_login_group() throws MalformedURLException {
        System.out.println("init login group.");
        classLevelSetup();
    }

    @BeforeMethod(groups = "login",enabled = false)
    public void init_login_situation(){
        System.out.println("login分组里的before method开始执行");
        loginPage = new LoginPage(appiumDriver);
        homePage = new HomePage(appiumDriver);
        pilePage = new PilePage(appiumDriver);
        loginPage.loginToHome("test007","Qwer1234@");
    }

    @AfterClass
    public void teardown() {
        System.out.println("执行after class");
        // 关闭服务
//        appiumDriver.quit();
    }

    @Test
    public void developTest(){
        Assert.assertEquals(1,0);
    }


}
