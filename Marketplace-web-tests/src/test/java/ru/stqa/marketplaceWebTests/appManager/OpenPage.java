package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenPage {
  private WebDriver driver;
  public OpenPage(WebDriver driver) {
   this.driver=driver;
  }

  public void clearField(String id) {

    driver.findElement(By.id(id)).clear();
  }

  public void passByCaptcha(String xpathExpression) {

    driver.findElement(By.xpath(xpathExpression)).click();
  }

  public void goToPage(String url) {

    driver.get(url);
  }
}
