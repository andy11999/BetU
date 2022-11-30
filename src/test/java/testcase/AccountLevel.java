package testcase;

import core.BaseSetup;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.SettingPage;
import page.SportbookPage;
import static constant.Common.BETU_URL;

public class AccountLevel extends BaseSetup {

    private String firstName="Andy";
    private String lastName="Tran";
    private String date="01/10/1999";
    private String city="Ha Noi";
    private String address="GoldenPark";
    private String state= "10989";
    private String country="Angola";

    @Test(priority = 1)
    public void updateAccountlevel1() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SettingPage settingPage= new SettingPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy74", "Betu_12345");
        settingPage.updateAccountLevel1(firstName,lastName,date,address,city,state,country);
    }

}
