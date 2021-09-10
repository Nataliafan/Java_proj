package ru.stqa.marketplaceWebTests.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.marketplaceWebTests.appManager.ApplicationManager;

public class TestBase {

  public ApplicationManager app = new ApplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.testBegin();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

    app.stop();
  }

}
