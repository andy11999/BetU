package com.betu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This is main of test,
 * Run full case test here.
 */
public class TestNGTest {
  WebDriver driver;

  @Test(priority = 2)
  public void test01() {
    WebDriverManager.chromedriver().setup(); // goi phien ban browser
    driver = new ChromeDriver(); // khoi tao gia tri cho driver
    driver.get("https://betu.io");

    driver.quit();
  }

  @Test(priority = 1)
  public void test02() {
    WebDriverManager.chromedriver().setup(); // goi phien ban browser
    driver = new ChromeDriver(); // khoi tao gia tri cho driver
    driver.get("https://google.com");

    driver.quit();
  }
}
