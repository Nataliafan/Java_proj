package ru.stqa.marketplaceWebTests.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.marketplaceWebTests.model.DriverProperty;

public class DriverSettings {


  public WebDriver driver;


  public DriverSettings(WebDriver driver) {
       this.driver= driver;
  }


    public void setDriverProperty(DriverProperty driverProperty) {
    System.setProperty(driverProperty.property, driverProperty.path);//"webdriver.chrome.driver", "C:\\Users\\Natalia\\Documents\\GitHub\\Repositories\\Java_proj\\Marketplace-web-tests\\drivers\\chromedriver.exe");

  }
}
