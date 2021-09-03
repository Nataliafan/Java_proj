package ru.stqa.marketplaceWebTests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MarketWebTests extends TestBase{

  @Test
  public void testMarketWeb() throws Exception {

    search(new SearchParams("header-search", "зеркало", ".BDkvP"));
    sortByValueAndPrint("//button[@data-autotest-id = 'dprice']");
    setBrowserTimeouts(60,TimeUnit.SECONDS);
  }


}
