package com.betu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test by main method when develop case test here
 */
public class RunTest {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    WebDriver driver;
    WebDriverManager.chromedriver().setup(); // goi phien ban browser
    driver = new ChromeDriver(); // khoi tao gia tri cho driver
    driver.get("https://google.com");
  }
}
