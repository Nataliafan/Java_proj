package ru.stqa.marketplaceWebTests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortingGoods extends TestBase{

  @Test
  public void testSearchAndSort() throws Exception {

    search(new SearchParams("header-search", "зеркало", ".BDkvP"));
    sortByValueAndPrint("//button[@data-autotest-id = 'dprice']");
    setBrowserTimeouts(60,TimeUnit.SECONDS);
  }


}
