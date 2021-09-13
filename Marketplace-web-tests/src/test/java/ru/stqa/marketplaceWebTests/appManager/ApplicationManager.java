package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.marketplaceWebTests.model.DriverProperties;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

public class ApplicationManager {
  private final SetDriverProperty setDriverProperty = new SetDriverProperty();
  public ChangeFocus changeFocus;
  public WebDriver driver;
  public Alerts alerts;
  public Sorting sorting;
  public OpenPage openPage;
  public BrowserTimeouts browserTimeouts;
  public ClickElement clickElement;
  public PrintFieldName printFieldName;

  public void testBegin() {

   setDriverProperty.getSetDriverProperty(new DriverProperties("webdriver.chrome.driver",
        "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe"));
   driver = new ChromeDriver();
   alerts = new Alerts(driver);
   browserTimeouts = new BrowserTimeouts(driver);
   openPage = new OpenPage(driver);
   sorting = new Sorting(driver);
   clickElement = new ClickElement(driver);
   changeFocus = new ChangeFocus(driver);
   printFieldName = new PrintFieldName(driver);
   browserTimeouts.setBrowserTimeouts(120, TimeUnit.SECONDS);
   openPage.goToPage("https://market.yandex.ru/");
   openPage.passByCaptcha("//input[@class = 'CheckboxCaptcha-Button']");
   openPage.clearField("header-search");
 }
  public void stop() {
    driver.quit();
    String verificationErrorString = alerts.verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
    public Sorting getSorting() {
    return sorting;
  }
    public ClickElement getClickElement(){return clickElement;}
    public ChangeFocus getChangeFocus() {return changeFocus;}
}
