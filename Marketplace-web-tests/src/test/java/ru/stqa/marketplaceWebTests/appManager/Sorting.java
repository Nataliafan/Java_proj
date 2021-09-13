package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.marketplaceWebTests.model.SearchParams;

public class Sorting {
  private WebDriver driver;
  public Sorting(WebDriver driver) {
    this.driver=driver;
  }

  public void sortByValueAndPrint(String sortingField) {
    String savedValue = driver.findElement(By.xpath(sortingField)).getText();
    System.out.println(savedValue);
    driver.findElement(By.xpath(sortingField)).click();
  }

  public void search(SearchParams searchParams) {

    driver.findElement(By.id(searchParams.fieldId())).sendKeys(searchParams.value());
    driver.findElement(By.cssSelector(searchParams.buttonId())).submit();
  }
}
