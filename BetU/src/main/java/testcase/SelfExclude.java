package testcase;

import core.BaseSetup;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.SettingPage;
import page.SportbookPage;
import static constant.Common.BETU_URL;

public class SelfExclude extends BaseSetup {


    @Test(priority = 1)
    public void selfExclude() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SettingPage settingPage= new SettingPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy76", "Betu_12345");
        settingPage.setSelftExclude();
    }
}
