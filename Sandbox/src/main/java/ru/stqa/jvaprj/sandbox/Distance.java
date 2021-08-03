package ru.stqa.jvaprj.sandbox;

public class Distance {
    public Point p1;
    public Point p2;

    public Distance (Point p1, Point p2){
        this.p1=p1;
        this.p2=p2;
    }


    public double distance(Point p1, Point p2){
        double X0 = (p2.x- p1.x);
        double Y0  = (p2.y-p1.y);
        return Math.sqrt((X0*X0)+(Y0*Y0));
    }


}

