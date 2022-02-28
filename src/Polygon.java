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
        for(int i=0; i<numVertices-2; i++){
            result+= (vertices[i+1].getX() + vertices[i].getX())*(vertices[i+1].getY()-vertices[i].getY());
        }

        //absolute value (sqrt() and multiply by itself)

        result = Math.sqrt(result*result);

        //divide by 2
        result = result/2;

        return result;
    }



}
