import java.lang.Math;

/**
 * Author: Jordan Eade
 * SENGG 2200 Assessment 1
 * The Polygon class holds all information and methods related to the storing and processing of polygons through the
 * program. Methods include; toString(), area(), closestToOrigin() and implementation of the ComparePoly interface.
 */
public class Polygon implements ComparePoly{
    //private members of class
    private Point[] vertices;
    private int numVertices;

    //constructor
    Polygon(){
        numVertices = 0;
        vertices = null;
    }

    //constructor
    Polygon(int num, Point[] verts){
        numVertices = num;
        vertices = verts;
    }

    /**
     * The toString() method is used to collate alll information about a polygon into a string to be printed by another
     * function. A loop is used to append each point to a string using the Point class toString() method followed by
     * formatting and the area of the polygon calculated by the area() method
     * @return String holding all information about polygon
     */
    public String toString(){

        //initialise string
        String str = "";
        //loop through each position in the array of Points
        for(int i=0; i<numVertices; i++){
            str += vertices[i].toString();  //append to string
        }
        str += ": " + String.format("%6.2f",area());    //add area
        return str;
    }

    /**
     * The area() method is used to calculate the area of the polygon using the formula for area from a set of cartesian points
     * referred to as the shoelace formula. A for loop is used to perform the summation aspect of the formula
     * @return double containing the area of the polygon given by the cartesian points
     */
    public double area(){
        //initialise double for result
        double result = 0;

        //loop for summation
        for(int i=0, a=1; i<numVertices; i++, a++){
            //summation aspect of shoelace formula
            result+= (vertices[a].getX() + vertices[i].getX())*(vertices[a].getY()-vertices[i].getY());
        }

        //absolute value (sqrt() of result squared)

        result = Math.sqrt(result*result);

        //divide by 2
        result = result/2;

        return result;
    }

    /**
     * The closestToOrigin() method is used to find the point closest to 0,0 in the polygon. The method utilises a for
     * loop to move through positions in the array of points and compare each to a temporary Point used as a holder.
     * @return The Point closest to 0,0
     */
    public double closestToOrigin(){

        //grab first
        Point holder = vertices[0];


        //loop to move through vertices array
        for(int i=1; i<numVertices; i++){
            //compare holder's distance from 0,0 to array position's distance from 0,0
            //if smaller reassign holder
            if(holder.distanceFromOrigin()>vertices[i].distanceFromOrigin()){
                holder = vertices[i];
            }
        }

        return holder.distanceFromOrigin();
    }

    /**
     * The ComesBefore() method is the implementation of the ComparePoly interface. The ComesBefore() method compares
     * the area of two polygons and returns true if the polygon calling the method is smaller than the passed polygon.
     * If the area of both polygons is equal (difference in area is less than or equal to 0.1% of smaller polygon's area)
     * then the polygon with the cartesian point closest to origin is considered to be smaller.
     * @param o the polygon to compare to
     * @return boolean result. True if o is larger
     */
    public boolean ComesBefore(Polygon o) {

        Polygon compare = o;
        //caluclating difference in area
        double diffArea = compare.area() - this.area();
        //absolute value of difference (sqrt() of difference squared)
        diffArea = Math.sqrt(diffArea * diffArea);

        boolean equal = false;
        //if the difference in area is less than or equal to 0.1% of smallest polygon's area then polygons are equal
        if (this.area() < compare.area() && diffArea / this.area() <= 0.001 || diffArea==0) {
            equal = true;
        } else if (compare.area() < this.area() && diffArea / compare.area() <= 0.001) {
            equal = true;
        }
        //if equal and passed object's distance from origin is larger then the calling object is considered to be smaller
        if(equal && this.closestToOrigin() < compare.closestToOrigin()){
            return true;
        }
        //if not equal and calling object's area is smaller
        else if(this.area()<compare.area())
            return true;
        else return false;

    }

}
