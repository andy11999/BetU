package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SettingPage extends BasePage {
    public SettingPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")
    WebElement menu;

    @FindBy (xpath ="//a[@href='/my/setting']" )
    WebElement settingButton;
    public void setSelftExclude() throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        Thread.sleep(300);
        settingButton.click();
        driver.findElement(By.xpath("//div[contains(text(),'Enable')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Yes, Self Exclude')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
        String timeSelfExclude= driver.findElement(By.xpath("//p[contains(text(),'not be able to make any bets until')]")).getText();
        System.out.println(timeSelfExclude);

    }


    public void setSpendingLimit(String money) throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        Thread.sleep(300);
        settingButton.click();
        driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys(money);
        driver.findElement(By.xpath("//span[contains(text(),'Set Limit')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm Limit')]")).click();
        String moneyLimit= driver.findElement(By.xpath("//p[contains(text(),'USD per Day')]")).getText();
        System.out.println(moneyLimit);

    }
    public void changeSpendingLimit(String moneyNew) throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        Thread.sleep(300);
        settingButton.click();
        driver.findElement(By.xpath("//span[contains(text(),'Change')]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys(moneyNew);
        driver.findElement(By.xpath("//span[contains(text(),'Set Limit')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm Limit')]")).click();
        String moneyLimit= driver.findElement(By.xpath("//p[contains(text(),'USD per Day')]")).getText();
        System.out.println(moneyLimit);

    }

    public void removeSpendingLimit() throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        Thread.sleep(300);
        settingButton.click();
        driver.findElement(By.xpath("//span[contains(text(),'Remove Limit')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm Limit')]")).click();
    }

    public void updateAccountLevel1(String firstName, String lastName, String date, String address, String city, String state, String cName) throws InterruptedException{
        Thread.sleep(1000);
        menu.click();
        Thread.sleep(300);
        settingButton.click();
        driver.findElement(By.xpath("//p[contains(text(),'Verify Account')]")).click();
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).sendKeys(date);
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
        driver.findElement(By.xpath("//div[@aria-labelledby='mui-component-select-country']")).click();
        List<WebElement> countries = driver.findElements(By.xpath(".//ul/li"));
        for(WebElement country: countries){
            String countryName= country.getText();
            if(countryName.equals(cName)){
                country.click();
                break;
            }
        }
        driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
        String notiSuccess= driver.findElement(By.xpath("//div[contains(text(),'Account verification level 1 completed.')]")).getText();
        System.out.println(notiSuccess);

    }


}
