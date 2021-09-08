package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.WebDriver;
import ru.stqa.marketplaceWebTests.model.DriverProperties;

public class SetProperty {


  public WebDriver driver;


  public SetProperty(WebDriver driver) {
       this.driver= driver;
  }


  public String getSetDriverProperty(DriverProperties driverProperties) {
    return System.setProperty(driverProperties.property(), driverProperties.path());

  }
}
