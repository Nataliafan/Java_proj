package ru.stqa.marketplaceWebTests.Tests;

import org.testng.annotations.Test;
import ru.stqa.marketplaceWebTests.model.SearchParams;
import java.util.concurrent.TimeUnit;

public class SortingGoods extends TestBase{

  @Test
  public void testSearchAndSort() throws Exception {
    app.getSorting().search(new SearchParams("header-search", "Смартфоны", ".BDkvP"));
    app.getSorting().sortByValueAndPrint("//button[@data-autotest-id = 'dprice']");

  }


}
