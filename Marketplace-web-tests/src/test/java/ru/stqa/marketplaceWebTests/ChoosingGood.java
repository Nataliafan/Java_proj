package ru.stqa.marketplaceWebTests;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ChoosingGood extends TestBase {


  @Test
  public void testChoosingGood() throws Exception {
    search(new SearchParams("header-search","Мобильные телефоны",".BDkvP"));
      driver.findElement(By.partialLinkText("Xiaomi Redmi 9 4/64GB")).click();
    String mainHandle = driver.getWindowHandle();
    System.out.println("Home Page Window ID: " + mainHandle + "\n");
    Set <String> allHandles = driver.getWindowHandles();
    System.out.println("Windows Open After Clicking The Link via Home Page: " + allHandles.size() + "\n");


    for (String windowHandle : allHandles) {
      if(mainHandle.equals(windowHandle)) {
        System.out.println("\t Window ID 1: \t" + windowHandle +
            "\n \t URL: \t \t" + driver.getCurrentUrl() +
            "\n \t Title: \t \t" + driver.getTitle());
      }
      else  {
        driver.switchTo().window(windowHandle);

        System.out.println("\t Window ID 2: \t" + windowHandle +
            "\n \t URL: \t \t" + driver.getCurrentUrl() +
            "\n \t Title: \t \t" + driver.getTitle());
      }
    }
      String getText = driver.findElement(By.partialLinkText("Характеристики")).getText();
    //      wait(1000000);
    System.out.println(getText);


    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
  }
}