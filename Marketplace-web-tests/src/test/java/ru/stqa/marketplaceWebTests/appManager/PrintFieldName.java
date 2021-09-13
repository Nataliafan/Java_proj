package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintFieldName {
  WebDriver driver;
  public PrintFieldName (WebDriver driver){
    this.driver=driver;
  }
  public void getTextParameterAndPrint(String fieldName) {
    String getText = driver.findElement(By.partialLinkText(fieldName)).getText();
    System.out.println(getText);
  }
}
