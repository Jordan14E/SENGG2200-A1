import java.lang.Math;
public class Polygon {

    Point[] vertices;
    int numVertices;

    Polygon(int num){
        numVertices = num;
        vertices = new Point[num];
    }

    public String toString(){

        //initialise string
        String str = "";
        for(int i=0; i<numVertices; i++){
            str += vertices[i].toString();
        }
        str += ": " + area();
        return str;
    }

    public double area(){
        //initialise double for result
        double result = 0;

        //loop for summation
        for(int i=0, a=1; i<numVertices-2; i++, a++){
            result+= (vertices[a].getX() + vertices[i].getX())*(vertices[a].getY()-vertices[i].getY());
        }

        //absolute value (sqrt() and multiply by itself)

        result = Math.sqrt(result*result);

        //divide by 2
        result = result/2;

        return result;
    }

    public Point closestToOrigin(){

        //grab first
        Point holder = vertices[0];



        for(int i=1; i<numVertices; i++){
            //compare holder's distance from main to array distance from main
            //if smaller reassign holder
            if(holder.distanceFromOrigin()>vertices[i].distanceFromOrigin()){
                holder = vertices[i];
            }
        }

        return holder;
    }

}
