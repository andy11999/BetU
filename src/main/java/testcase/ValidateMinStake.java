package testcase;

import core.BaseSetup;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.MyBetsPage;
import page.SportbookPage;
import static constant.Common.BETU_URL;

public class ValidateMinStake extends BaseSetup {
    private String username = "andy1";
    private String password = "Betu_12345";
    private String stake= "0.5";
    @Test
    public void validateMinStake() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        MyBetsPage myBetsPage = new MyBetsPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        sportbookPage.gotoMyBets(stake);


    }


}
