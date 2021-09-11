package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BrowserTimeouts {
  private WebDriver driver;
  public BrowserTimeouts(WebDriver driver){

    this.driver=driver;
  }
  public void setBrowserTimeouts(int time, TimeUnit timeUnit) {
    driver.manage().timeouts().implicitlyWait(time, timeUnit);
  }
}
