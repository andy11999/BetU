package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath="//input[@name='username']")
    WebElement username;
    @FindBy (xpath = "//input[@name='password']")
    WebElement password;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnLogin;

    public SportbookPage gotoSportbookPage(String userName, String passWord){
        writeText(username,userName);
        writeText(password,passWord);
        click(btnLogin);
        return new SportbookPage(driver);
    }

}
