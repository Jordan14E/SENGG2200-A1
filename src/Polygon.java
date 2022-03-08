import java.lang.Math;
public class Polygon implements ComparePoly{

    Point[] vertices;
    int numVertices;

    Polygon(){
        numVertices = 0;
        vertices = null;
    }

    Polygon(int num, Point[] verts){
        numVertices = num;
        vertices = verts;
    }

    public String toString(){

        //initialise string
        String str = "";
        for(int i=0; i<numVertices; i++){
            str += vertices[i].toString();
        }
        str += ": " + String.format("%6.2f",area());
        return str;
    }

    public double area(){
        //initialise double for result
        double result = 0;

        //loop for summation
        for(int i=0, a=1; i<numVertices; i++, a++){
            result+= (vertices[a].getX() + vertices[i].getX())*(vertices[a].getY()-vertices[i].getY());
        }

        //absolute value (sqrt() and multiply by itself)

        result = Math.sqrt(result*result);

        //divide by 2
        result = result/2;

        return result;
    }

    public double closestToOrigin(){

        //grab first
        Point holder = vertices[0];



        for(int i=1; i<numVertices; i++){
            //compare holder's distance from main to array distance from main
            //if smaller reassign holder
            if(holder.distanceFromOrigin()>vertices[i].distanceFromOrigin()){
                holder = vertices[i];
            }
        }

        return holder.distanceFromOrigin();
    }


    public boolean ComesBefore(Polygon o) {

        Polygon compare = o;

        double diffArea = compare.area() - this.area();

        diffArea = Math.sqrt(diffArea * diffArea);

        boolean equal = false;

        if (this.area() < compare.area() && diffArea / this.area() <= 0.001 || diffArea==0) {
            equal = true;
        } else if (compare.area() < this.area() && diffArea / compare.area() <= 0.001) {
            equal = true;
        }

        if(equal && this.closestToOrigin() < compare.closestToOrigin()){
            return true;
        }
        else if(this.area()<compare.area())
            return true;
        else return false;

    }

}
