package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy (xpath = "//span[contains(text(),'Login')]")
    WebElement btnLogin;

    public LoginPage gotoLoginPage(){
        click(btnLogin);
        return new LoginPage(driver);

    }


}
