package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ChangeFocus {
  private WebDriver driver;
  public ChangeFocus(WebDriver driver){
    this.driver=driver;
  }
  public void changeFocus() {
    String mainHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String windowHandle : allHandles) {
      if(mainHandle.equals(windowHandle)) {
        System.out.println("...");
      }
      else  {
        driver.switchTo().window(windowHandle);

        System.out.println("\t Window ID 2: \t" + windowHandle +
            "\n \t URL: \t \t" + driver.getCurrentUrl() +
            "\n \t Title: \t \t" + driver.getTitle());
      }
    }
  }
}
