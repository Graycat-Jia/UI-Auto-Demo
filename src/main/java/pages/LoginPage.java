package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @Author GrayCat.
 * @date 2022/01/12 10:48
 */
public class LoginPage extends BasePage{

    public LoginPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    By usernameId = By.id("com.growatt.chargingpile:id/et_username");
    By passwordId = By.id("com.growatt.chargingpile:id/et_password");
    By submitId = By.id("com.growatt.chargingpile:id/bt_login");

    public HomePage loginToHome( String username, String password ){
        writeText(usernameId,username);
        writeText(passwordId,password);
        click(submitId);
        return new HomePage(appiumDriver);
    }



}
