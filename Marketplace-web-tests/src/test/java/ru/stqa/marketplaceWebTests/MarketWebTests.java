package ru.stqa.marketplaceWebTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

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
    goToPage(baseUrl); //("https://market.yandex.ru/");
    passByCaptcha("//input[@class = 'CheckboxCaptcha-Button']");
    clearField("header-search");
  }

  private void clearField(String id) {
    driver.findElement(By.id(id)).clear();
  }
  private void passByCaptcha(String xpathExpression) {
    driver.findElement(By.xpath(xpathExpression)).click();
  }
  private void goToPage(String url) {
    driver.get(url);
  }

  @Test
  public void testMarketWeb() throws Exception {

    fillInField("header-search", "зеркало");
    pressButton(".BDkvP");
    String sortingValue = saveValue("//button[@data-autotest-id", "'dprice'");
    sortByValue("//button[@data-autotest-id", "'dprice'");
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) ='по цене'])")).click();
    printSortingValue(sortingValue);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  private void printSortingValue(String sortingValue) {
    System.out.println(sortingValue);
  }

  private void sortByValue(String buttonClass, String buttonId) {
    driver.findElement(By.xpath(buttonClass + " = " + buttonId + "]")).click();
  }

  private String saveValue(String buttonClass, String buttonId) {
    String savedValue = driver.findElement(By.xpath(buttonClass + " = " + buttonId + "]")).getText();
    return savedValue;
  }

  private void pressButton(String buttonId) {
    driver.findElement(By.cssSelector(buttonId)).submit();
  }

  private void fillInField(String fieldId, String value) {
    driver.findElement(By.id(fieldId)).sendKeys(value);
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
