package ru.stqa.marketplaceWebTests.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.marketplaceWebTests.appManager.ApplicationManager;

public class TestBase {

  public ApplicationManager app = new ApplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.driverSettings.setDriverProperty;
//    app.driverSettings.setDriverProperty("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe");
  //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe");
    app.testBegin();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

    app.stop();
  }

}
