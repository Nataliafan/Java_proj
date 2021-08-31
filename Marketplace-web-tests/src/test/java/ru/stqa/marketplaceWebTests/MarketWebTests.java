package ru.stqa.marketplaceWebTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MarketWebTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://market.yandex.ru/";
    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    driver.get("https://market.yandex.ru/");
    driver.findElement(By.xpath("//input[@class = 'CheckboxCaptcha-Button']")).click();
    driver.findElement(By.id("header-search")).clear();
  }

  @Test
  public void testMarketWeb() throws Exception {

    driver.findElement(By.id("header-search")).sendKeys("зеркало");
    final String searchString = driver.findElement(By.id("header-search")).getText();
    driver.findElement(By.cssSelector(".BDkvP")).submit();
    driver.findElement(By.xpath("//button[@data-autotest-id = 'dprice']")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) ='по цене'])")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
