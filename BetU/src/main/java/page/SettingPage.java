package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SettingPage extends BasePage {
    public SettingPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public void setSelftExclude() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//a[@href='/dashboard/setting']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Enable')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Yes, Self Exclude')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
        String timeSelfExclude= driver.findElement(By.xpath("//p[contains(text(),'not be able to make any bets until')]")).getText();
        System.out.println(timeSelfExclude);

    }


    public void setSpendingLimit(String money) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//a[@href='/dashboard/setting']")).click();
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
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//a[@href='/dashboard/setting']")).click();
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
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[4]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//a[@href='/dashboard/setting']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Remove')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Confirm Limit')]")).click();
    }


}
