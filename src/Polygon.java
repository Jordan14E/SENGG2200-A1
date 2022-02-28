
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

        return str;
    }


}
