import java.lang.Math;

public class Point {


    double x;
    double y;

    public double distanceFromOrigin(Point o){
        //initialise result
        double result;
        //calculation
        result = Math.sqrt(((this.x - o.x)*(this.x - o.x))+((this.y - o.y)*(this.y - o.y)));

        return result;
    }

    public String toString(){
        //initialise string
        String str = "("+this.x+" ,"+this.y+") ";
        return str;
    }




}
