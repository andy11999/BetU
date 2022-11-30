package testcase;

import core.BaseSetup;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.SettingPage;
import page.SportbookPage;

import static constant.Common.BETU_URL;

public class SpendingLimit extends BaseSetup {
    private String money= "5";
    private String username="andy86";
    private String password= "Betu_12345";

    @Test(priority = 1)
    public void setSpendingLimit() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SettingPage settingPage= new SettingPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        settingPage.setSpendingLimit(money);
    }

    @Test(priority = 2)
    public void changeSpendingLimit() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SettingPage settingPage= new SettingPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        settingPage.changeSpendingLimit("7");
    }

    @Test(dependsOnMethods = "changeSpendingLimit")
    public void removeSpendingLimit() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SettingPage settingPage= new SettingPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        Thread.sleep(300000);
        settingPage.removeSpendingLimit();
    }
}
