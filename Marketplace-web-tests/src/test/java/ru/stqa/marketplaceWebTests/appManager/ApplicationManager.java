package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.marketplaceWebTests.model.DriverProperties;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
  private final SetDriverProperty setDriverProperty = new SetDriverProperty();
  public WebDriver driver;
  public String baseUrl;
  public boolean acceptNextAlert = true;
  public StringBuffer verificationErrors = new StringBuffer();

  public void init() {
    setDriverProperty.getSetDriverProperty(new DriverProperties("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe"));
    driver = new ChromeDriver();
    baseUrl = "https://market.yandex.ru/";
    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    driver.get("https://market.yandex.ru/");
    driver.findElement(By.xpath("//input[@class = 'CheckboxCaptcha-Button']")).click();
    driver.findElement(By.id("header-search")).clear();
  }

  public void stop() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
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

  public SetDriverProperty getSetDriverProperty() {
    return setDriverProperty;
  }
}
