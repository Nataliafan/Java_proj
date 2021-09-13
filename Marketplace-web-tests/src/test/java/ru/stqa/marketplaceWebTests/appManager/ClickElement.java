package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClickElement {

  private WebDriver driver;
  public ClickElement(WebDriver driver) {

    this.driver=driver;
  }

  public void clickElement(String partialLinkText) {
    driver.findElement(By.partialLinkText(partialLinkText)).click();
  }
}
