package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SportbookPage extends BasePage {
    public SportbookPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

////    @FindBys (@FindBy (xpath = "//button[@title='Draw']"))
////    List<WebElement> outcome;
//    @FindBy (xpath = "//span[@class='jss340']")
//    WebElement outcome;
    @FindBy (xpath = "//span[contains(text(),'Multi')]")
    WebElement tabMulti;
//    @FindBy (xpath = "//div[@class='MuiInputBase-root jss142 jss373 MuiInputBase-fullWidth MuiInputBase-adornedEnd jss149']")
//    WebElement stakeValue;
    @FindBy (xpath = "//p[contains(text(),'Minimum stake')]")
    WebElement validateMessage;
    @FindBy (xpath = "//p[contains(text(),'Alternative')]")
    WebElement validateAl;
    @FindBy (xpath = "//span[contains(text(),'Place Bets')]")
    WebElement btnPlaceBet;
    @FindBy (xpath = "//span[contains(text(),'Make Another Bet')]")
    WebElement btnMakeAnotherBet;
    @FindBy (xpath = "//span[contains(text(),'Go to My Bets')]")
    WebElement btnViewBet;
    @FindBy (xpath = "//span[contains(text(),'Accept Alternative Stake')]")
    WebElement btnAcceptAlternativeStake;
    @FindBy ( id = "notistack-snackbar")
    WebElement toastSelf;

//    @FindBy (xpath = "//input[@type='checkbox']")
//    WebElement checkboxAutoOdds;

    public void getMessageAccountLevel(String stake) throws  InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        click(tabMulti);
        Thread.sleep(500);
        WebElement stakeValue= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"));
        writeText(stakeValue,stake);
        click(btnPlaceBet);
        String message= driver.findElement(By.xpath("//p[contains(text(),'Please complete Level')]")).getText();
        System.out.println(message);


    }

    public void getSelfexclude() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        waitVisibility(toastSelf);
        String message= toastSelf.getText();
        System.out.println(message);
    }

    public void getSpendingLimit(String stake) throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        click(tabMulti);
        Thread.sleep(500);
        WebElement stakeValue= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"));
        writeText(stakeValue,stake);
        click(btnPlaceBet);
        String message= driver.findElement(By.xpath("//p[contains(text(),'Your spending limit')]")).getText();
        System.out.println(message);
    }

    public void getValidateMessage(String stake) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        click(tabMulti);
        Thread.sleep(500);
        WebElement stakeValue= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"));
        writeText(stakeValue,stake);
        String message= validateMessage.getText();
        System.out.println(message);

    }

    public void getAlternativeStake(String stake) throws  InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        click(tabMulti);
        Thread.sleep(500);
        WebElement stakeValue= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"));
        writeText(stakeValue,stake);
//        WebElement checkboxAutoOdds = driver.findElement(By.xpath("//input[@type='checkbox']"));
//        click(checkboxAutoOdds);
        click(btnPlaceBet);
        String message= validateAl.getText();
        System.out.println(message);
        click(btnMakeAnotherBet);
        click(btnAcceptAlternativeStake);
        click(btnPlaceBet);

    }

    public MyBetsPage gotoMyBets(String stake) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'u/sport')]")).click();
        Thread.sleep(1000);
        List<WebElement> listOutcome = driver.findElements(By.xpath("//button[@title='Draw']"));
        for(int i=0; i< listOutcome.size() ;i++){
            try {
                listOutcome.get(i).findElement(By.xpath("//button[@title='Draw']")).click();
            }catch(NoSuchElementException e){
                break;
            }
        }
        click(tabMulti);
        Thread.sleep(500);
        WebElement stakeValue= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"));
        writeText(stakeValue,stake);
        click(btnPlaceBet);
        click(btnViewBet);
        return new MyBetsPage(driver);
    }

}
