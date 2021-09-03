package ru.stqa.marketplaceWebTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
  protected WebDriver driver;
  protected String baseUrl;
  protected boolean acceptNextAlert = true;
  protected StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://market.yandex.ru/";
    setBrowserTimeouts(120, TimeUnit.SECONDS);
    goToPage(baseUrl); //("https://market.yandex.ru/");
    passByCaptcha("//input[@class = 'CheckboxCaptcha-Button']");
    clearField("header-search");
  }

  public void setBrowserTimeouts(int time, TimeUnit timeUnit) {
    driver.manage().timeouts().implicitlyWait(time, timeUnit);
  }

  protected void clearField(String id) {

    driver.findElement(By.id(id)).clear();
  }

  protected void passByCaptcha(String xpathExpression) {

    driver.findElement(By.xpath(xpathExpression)).click();
  }

  protected void goToPage(String url) {

    driver.get(url);
  }

  protected void sortByValueAndPrint(String sortingField) {
    String savedValue = driver.findElement(By.xpath(sortingField)).getText();
    System.out.println(savedValue);
    driver.findElement(By.xpath(sortingField)).click();
  }

  protected void search(SearchParams searchParams) {

    driver.findElement(By.id(searchParams.fieldId())).sendKeys(searchParams.value());
    driver.findElement(By.cssSelector(searchParams.buttonId())).submit();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  protected boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  protected boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected String closeAlertAndGetItsText() {
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
