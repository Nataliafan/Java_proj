package ru.stqa.marketplaceWebTests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.marketplaceWebTests.appManager.ApplicationManager;

public class TestBase {

  public final ApplicationManager app = new ApplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
