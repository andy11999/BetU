package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WalletPage extends BasePage {
    public WalletPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")
    WebElement menu;
    @FindBy (xpath ="//a[@href='/dashboard/wallet']" )
    WebElement myWalletButton;


    public void goToMyWallet() throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        myWalletButton.click();
    }

    public void deposit(String coinSymbol, String networkName) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/dashboard/wallet/deposit']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Coin']")).click();
        List<WebElement> coins= driver.findElements(By.xpath(".//ul/li"));
        for(WebElement coin: coins){
            String coinName= coin.getText();
            if(coinName.equals(coinSymbol)){
                coin.click();
                break;
            }

        }
        driver.findElement(By.xpath("//input[@placeholder='Select Network']")).click();
        List<WebElement> networks= driver.findElements(By.xpath(".//ul/li"));
        for(WebElement network: networks){
            String networkN = network.getText();
            if(networkN.equals(networkName)){
                network.click();
                break;
            }
        }
        Thread.sleep(3000);


    }

}
