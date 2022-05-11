package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import ru.stqa.marketplaceWebTests.model.DriverProperties;
import static org.testng.Assert.fail;

public class ApplicationManager {
  private final String browser;
  private final SetDriverProperty setDriverProperty = new SetDriverProperty();
  public WebDriver driver;
  public ChangeFocus changeFocus;
  public Alerts alerts;
  public Sorting sorting;
  public OpenPage openPage;
  public BrowserTimeouts browserTimeouts;
  public ClickElement clickElement;
  public PrintFieldName printFieldName;

  public ApplicationManager(String browser) {
        this.browser = browser;
  }
  public void testBegin() {

if (browser == Browser.CHROME.browserName()) {
  setDriverProperty.getSetDriverProperty(new DriverProperties("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe"));
  driver = new ChromeDriver();
} else {
  System.out.println("Тест предназначен для браузера Chrome");
}
   alerts = new Alerts(driver);
   browserTimeouts = new BrowserTimeouts(driver);
   openPage = new OpenPage(driver);
   sorting = new Sorting(driver);
   clickElement = new ClickElement(driver);
   changeFocus = new ChangeFocus(driver);
   printFieldName = new PrintFieldName(driver);
   openPage.goToPage("https://market.yandex.ru/");
   browserTimeouts.setBrowserTimeouts(60);

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
