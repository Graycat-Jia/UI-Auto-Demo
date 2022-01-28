package pages;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @Author GrayCat.
 * @date 2022/01/12 10:36
 */
public class BasePage {
    public AppiumDriver appiumDriver;
    public WebDriverWait appiumDriverWait;


    public BasePage(AppiumDriver driver){
        this.appiumDriver = driver;
        appiumDriverWait = new WebDriverWait(driver, 10 );
    }

    public AppiumDriver getAppiumDriver(){
        return appiumDriver;
    }

    // 向下滑半个屏幕
    public void slideDown(){
        // 滑动之后点击--？？
        PointOption pointOptionStart, pointOptionEnd;
        // 有时底部有菜单，隔开它
        int edgeBorder = 10;
        // 获取屏幕尺寸
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width/2, edgeBorder);
        // 下滑屏幕
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }

    // 主动等待
    public void waitSecond( long time ) throws InterruptedException {
        Thread.sleep(time);
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return appiumDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}
