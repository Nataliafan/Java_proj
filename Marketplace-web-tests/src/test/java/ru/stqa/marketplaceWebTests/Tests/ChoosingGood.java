package ru.stqa.marketplaceWebTests.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.marketplaceWebTests.model.SearchParams;

import java.util.Set;

public class ChoosingGood extends TestBase {


  @Test
  public void testChoosingGood() throws Exception {
    app.getSorting().search(new SearchParams("header-search","Мобильные телефоны",".BDkvP"));
      app.driver.findElement(By.partialLinkText("Xiaomi Redmi 9 4/64GB")).click();

    String mainHandle = app.driver.getWindowHandle();
    System.out.println("Home Page Window ID: " + mainHandle + "\n");
    Set <String> allHandles = app.driver.getWindowHandles();
    System.out.println("Windows Open After Clicking The Link via Home Page: " + allHandles.size() + "\n");


    for (String windowHandle : allHandles) {
      if(mainHandle.equals(windowHandle)) {
        System.out.println("\t Window ID 1: \t" + windowHandle +
            "\n \t URL: \t \t" + app.driver.getCurrentUrl() +
            "\n \t Title: \t \t" + app.driver.getTitle());
      }
      else  {
        app.driver.switchTo().window(windowHandle);

        System.out.println("\t Window ID 2: \t" + windowHandle +
            "\n \t URL: \t \t" + app.driver.getCurrentUrl() +
            "\n \t Title: \t \t" + app.driver.getTitle());
      }
    }
      String getText = app.driver.findElement(By.partialLinkText("Характеристики")).getText();

    System.out.println(getText);


    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
  }
}