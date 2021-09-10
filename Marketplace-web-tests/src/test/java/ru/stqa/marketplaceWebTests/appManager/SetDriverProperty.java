package ru.stqa.marketplaceWebTests.appManager;

import ru.stqa.marketplaceWebTests.model.DriverProperties;

public class SetDriverProperty {
  public String getSetDriverProperty(DriverProperties driverProperties) {
    return System.setProperty(driverProperties.property(), driverProperties.path());
  }
}
