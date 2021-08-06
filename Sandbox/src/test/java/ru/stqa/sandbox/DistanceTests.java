package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {
  @Test
  public void testDistance1(){
    Point p1 = new Point(1,6);//задаем координаты точки 1 (0, 6)
    Point p2 = new Point(2, 7);//задаем координаты точки 2 (0, 7)
    Distance dist = new Distance(p1,p2);//создаем объект с массивом координат точек 1 и 2
    Assert.assertEquals (dist.distance(p1,p2),1);//проверяем, что расстояние между точками равно ожидаемому (1)
  }

}
