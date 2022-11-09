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
    @FindBy (xpath = "//span[contains(text(),'Place')]")
    WebElement btnPlaceBet;
    @FindBy (xpath = "//p[contains(text(),'Minimum')")
    WebElement validateMessage;

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
        WebElement stakeValue= driver.findElement(By.xpath("//input[@class='MuiInputBase-input jss143 MuiInputBase-inputAdornedEnd jss147']"));
        writeText(stakeValue,stake);
        if(btnPlaceBet.isDisplayed()){
            click(btnPlaceBet);
        }else{
            String message= validateMessage.getText();
            System.out.println(message);
            String []word= message.split(" ");
            writeText(stakeValue,word[4]);
            click(btnPlaceBet);

        }

        return new MyBetsPage(driver);
    }

}
