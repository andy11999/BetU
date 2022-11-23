package testcase;

import core.BaseSetup;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.SportbookPage;
import static constant.Common.BETU_URL;

public class ValidateBetSlip extends BaseSetup {
    private String username = "andy9";
    private String password = "Betu_12345";
    private String stake= "0.5";
    private String alStake="10000";
    private String realStake="100";

    @Test(priority = 1)
    public void accountLevel() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy70", "Betu_12345");
        sportbookPage.getMessageAccountLevel(realStake);
    }

    @Test(priority = 2)
    public void selfExclude() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy71", "Betu_12345");
        sportbookPage.getSelfexclude();
    }
    @Test(priority = 3)
    public void spendingLimit() throws  InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy86", "Betu_12345");
        sportbookPage.getSpendingLimit(realStake);
    }

    @Test(priority = 4)
    public void multiSameFixture() throws  InterruptedException{
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage("andy86", "Betu_12345");
        sportbookPage.getMultiSameFixture();
    }

    @Test(priority = 5)
    public void validateMinStake() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        sportbookPage.getValidateMessage(stake);


    }

    @Test(priority = 6)
    public void validateInsufficentBalance() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        sportbookPage.getInsufficentBalance(alStake);


    }

    @Test(priority = 7)
    public void vailidateALternativeStake() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        sportbookPage.getAlternativeStake(alStake);
    }
    @Test(priority = 8)
    public void gotoMyBet() throws InterruptedException {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage= new LoginPage(driver);
        SportbookPage sportbookPage= new SportbookPage(driver);
        homePage.gotoUrl(BETU_URL);
        homePage.gotoLoginPage();
        loginPage.gotoSportbookPage(username, password);
        sportbookPage.gotoMyBets(realStake);
    }







}

