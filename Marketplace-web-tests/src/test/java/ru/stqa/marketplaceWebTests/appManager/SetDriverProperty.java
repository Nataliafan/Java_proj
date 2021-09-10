package ru.stqa.marketplaceWebTests.appManager;

import ru.stqa.marketplaceWebTests.model.DriverProperties;

public class SetDriverProperty {
  public void getSetDriverProperty(DriverProperties driverProperties) {
    System.setProperty(driverProperties.property(), driverProperties.path());
  }

}
