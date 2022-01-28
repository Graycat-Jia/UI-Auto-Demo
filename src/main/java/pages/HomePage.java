package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @Author GrayCat.
 * @date 2022/01/12 16:53
 */
public class HomePage extends BasePage{

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    By piles_name = By.id("com.growatt.chargingpile:id/tv_name");


    public HomePage ifLoginPageThenLogin( String username,String password ){
        try{
            LoginPage loginPage = new LoginPage(super.appiumDriver);
            loginPage.loginToHome(username,password);
        }
        catch (Exception e){
            System.out.println("直接进入首页.充电桩列表.");
        }finally {
            return this;
        }
    }

    public PilePage goToPilePage(String pileName ) {
        List<WebElement> nameList = getAppiumDriver().findElements(piles_name);
        // 查找跟名字一样的电桩，点击
        for (WebElement item : nameList){
            if (item.getText().equals(pileName)){
                item.click();
            }
        }
        return new PilePage(appiumDriver);
    }


}
