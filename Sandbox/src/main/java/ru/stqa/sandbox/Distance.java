package ru.stqa.sandbox;

public class Distance {
  public Point p1;
  public Point p2;

  public Distance (Point p1, Point p2){
    this.p1=p1;
    this.p2=p2;
  }

  public int distance(Point p1, Point p2){
    int X0 = (int) (p2.x- p1.x);
    int Y0  = (int) (p2.y-p1.y);
    return (int) Math.sqrt((X0*X0)+(Y0*Y0));
  }

}
