import java.lang.Math;

public class Point {

    private double x, y;

    Point() {
        x = 0;
        y = 0;
    }
    Point(double X, double Y){
        x = X;
        y = Y;
    }

    public double distanceFromOrigin(){
        //initialise result
        double result;
        //calculation
        result = Math.sqrt((this.x*this.x)+(this.y*this.y));
        return result;
    }

    public String toString(){
        //initialise string
        String str = "("+String.format("%4.2f", x)+" ,"+String.format("%4.2f", y)+") ";
        return str;
    }

    double getX(){
        return x;
    }

    double getY(){
        return y;
    }

}
