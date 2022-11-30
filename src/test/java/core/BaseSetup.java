package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseSetup {
  public WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void initChromeDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

  }

  @AfterMethod
  public void close() {
    driver.quit();
  }

}
