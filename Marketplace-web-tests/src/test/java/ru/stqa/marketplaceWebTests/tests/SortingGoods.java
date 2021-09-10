package ru.stqa.marketplaceWebTests.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class SortingGoods extends TestBase{

  @Test
  public void sorting() throws Exception {

    app.driver.findElement(By.id("header-search")).sendKeys("зеркало");
    final String searchString = app.driver.findElement(By.id("header-search")).getText();
    app.driver.findElement(By.cssSelector(".BDkvP")).submit();
    app.driver.findElement(By.xpath("//button[@data-autotest-id = 'dprice']")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) ='по цене'])")).click();
    app.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

}
