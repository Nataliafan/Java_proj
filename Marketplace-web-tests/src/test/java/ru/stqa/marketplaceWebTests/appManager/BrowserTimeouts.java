package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class BrowserTimeouts {
  private WebDriver driver;
  public BrowserTimeouts(WebDriver driver){

    this.driver=driver;
  }
  public void setBrowserTimeouts(int time) {
//    driver.manage().timeouts().implicitlyWait(time, timeUnit);
    WebDriver.Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
  }
}
