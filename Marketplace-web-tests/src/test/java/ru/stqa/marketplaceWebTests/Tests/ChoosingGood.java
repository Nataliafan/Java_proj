package ru.stqa.marketplaceWebTests.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.marketplaceWebTests.model.SearchParams;

public class ChoosingGood extends TestBase {


  @Test
  public void testChoosingGood() throws Exception {
    app.getSorting().search(new SearchParams("header-search","Мобильные телефоны",".BDkvP"));
    app.getSorting().sortByValueAndPrint("//button[@data-autotest-id = 'dpop']");
    app.getClickElement().clickElement("Xiaomi Redmi 9 4/64GB");
    app.getChangeFocus().changeFocus();
    app.printFieldName.getTextParameterAndPrint("Характеристики");

  }




}