package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PilePage;
import utils.ReportExtent;


/**
 * @Author GrayCat.
 * @date 2022/01/12 10:26
 */

public class Case1 extends BaseCase{
    @Test(description = "这是用例的描述：正常登陆用例")
    public void test_login_success(){
        ReportExtent.extent.createTest("登陆用例--正常Project EV登陆");
        loginPage.loginToHome( "test007","Qwer1234@" );
    }

    @Test(description = "充电：直接充电.(直接点击中间的按钮，无判断)")
    public void chargeDirectly() throws InterruptedException {
        homePage.ifLoginPageThenLogin("test007","Qwer1234@")
                .goToPilePage("D0BSB19004")
                .clickCharge();
        Assert.assertEquals( pilePage.getToastMsg(),"成功发送指令" );
    }


    @Test(description = "这是用例的描述：常规的登陆和退出登陆",enabled = false)
    public void exit_login_normal(){
        ReportExtent.extent.createTest("登陆之后退出登陆");
        // 直接点左边的运行会运行 把分组里的初始化环境也运行了，所以得把下面得登陆态注释掉
//        loginPage.loginToShinePhone( "zxcv001","123456" );
//        homePage.goToMinePage();
        pilePage.exitLogin();
    }


}
