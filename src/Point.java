import java.lang.Math;

/***
 * The Point class is used to hold all data and methods for a singular cartesian point. Methods include,
 * distanceFromOrigin() and toString() as well as getters for X and Y coordinates.
 */
public class Point {

    //cartesian points
    private double x, y;

    //constructor
    Point() {
        x = 0;
        y = 0;
    }

    //constructor
    Point(double X, double Y){
        x = X;
        y = Y;
    }

    /**
     * The distanceFromOrigin() method is used to find the distance between 0,0 and the point. It uses the formula for
     * distance between two cartesian points.
     * @return distance between 0,0 and point
     */
    public double distanceFromOrigin(){
        //initialise result
        double result;
        //calculation
        result = Math.sqrt((this.x*this.x)+(this.y*this.y));
        return result;
    }

    /**
     * The toString() function is used to collate the point to a string in a format ready to be printed by another
     * function
     * @return String holding all the information to print
     */
    public String toString(){
        //initialise string
        String str = "("+String.format("%4.2f", x)+" ,"+String.format("%4.2f", y)+") ";
        return str;
    }

    /**
     * getter for X coordinate
     * @return x coordinate
     */
    double getX(){
        return x;
    }

    /**
     * getter for Y coordinate
     * @return y coordinate
     */
    double getY(){
        return y;
    }

}
