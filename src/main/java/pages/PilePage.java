package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author GrayCat.
 * @date 2022/01/12 19:03
 */
public class PilePage extends BasePage{
    private static String toastMsg = "";

    public PilePage(AppiumDriver driver) {
        super(driver);
    }

    By back_btn = By.id("");
    By charge_btn = By.id("com.growatt.chargingpile:id/iv_switch");
    By toast_msg = By.xpath("//android.widget.Toast[contains(@text,'成功发送命令')]");
    By toast_msg_test = By.xpath("//android.widget.Toast[@text='成功发送命令']");
    By toast_msg_by_xclass = By.xpath("//*[@class='android.widget.Toast']");

    public LoginPage exitLogin(){
       // ----
        return new LoginPage(appiumDriver);
    }

    public PilePage clickCharge() throws InterruptedException {
        waitSecond(3000);
        click(charge_btn);
//        WebDriverWait wait = new WebDriverWait(appiumDriver,10, 100);
//        toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(toast_msg_by_xclass)).getText();
        toastMsg = appiumDriver.findElement(toast_msg_by_xclass).getText();
        System.out.println("toast消息：" + toastMsg);
        return this;
    }

    public String getToastMsg() {
        System.out.println("excute获取toast信息,get方法返回的：" + toastMsg);
        return toastMsg;
    }
}
