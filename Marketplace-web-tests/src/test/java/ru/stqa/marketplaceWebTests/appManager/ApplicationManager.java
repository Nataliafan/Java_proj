package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.marketplaceWebTests.model.DriverProperties;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
  public Alerts alerts;
  public Sorting sorting;
  public OpenPage openPage;
  public BrowserTimeouts browserTimeouts;
  public WebDriver driver;
  public SetProperty setProperty;


  public String baseUrl;

  public void testBegin() {
   setProperty = new SetProperty(driver);
    driver = new ChromeDriver();

   alerts = new Alerts(driver);
   browserTimeouts = new BrowserTimeouts(driver);
   openPage = new OpenPage(driver);
   setProperty.getSetDriverProperty(new DriverProperties("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe"));
   browserTimeouts.setBrowserTimeouts(120, TimeUnit.SECONDS);
   openPage.goToPage("https://market.yandex.ru/");
   openPage.passByCaptcha("//input[@class = 'CheckboxCaptcha-Button']");
   openPage.clearField("header-search");
   sorting = new Sorting(driver);
 }
  public void stop() {
    driver.quit();
    String verificationErrorString = alerts.verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  public SetProperty getSetProperty(){
    return setProperty;
  }

  public BrowserTimeouts getBrowserTimeouts() {
    return browserTimeouts;
  }
  public OpenPage getOpenPage() {
    return openPage;
  }
  public Sorting getSorting() {
    return sorting;
  }
  public Alerts getAlerts() {
    return alerts;
  }


}
