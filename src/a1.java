
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class a1 {

    public static void main(String[] args){

        System.out.println("Please enter the name of the file you want to read from including the proper extension. \n" +
                "E.g. '.txt':\n");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        File file = new File(fileName);
        Scanner input = null;
        try{
            input = new Scanner(file);
        }
        catch(FileNotFoundException f){
            System.out.println("File could not be found.");
        }

        MyPolygons unsorted = new MyPolygons();

        unsorted= unsorted(unsorted,input);
        System.out.println(unsorted.printing());

    }

    //will read into the unsorted MyPolygon sin the order of the input
    public static MyPolygons unsorted(MyPolygons unsorted, Scanner input){

        //find the P
//        while(input.hasNextLine()){
//            System.out.println(input.next());
//        }
        while(input.hasNextLine() && input.next().equals("P")){
            int vertices = input.nextInt();
            Point[] points = new Point[vertices+1];
            double x, y;

            for(int i=0; i<vertices;i++){
                x = input.nextDouble();
                y = input.nextDouble();
                points[i] = new Point(x,y);
            }
            points[vertices] = new Point(points[0].getX(), points[0].getY());
            Polygon p = new Polygon(vertices, points);
            unsorted.append(p);
        }

        return unsorted;
    }

//    public MyPolygons sorted(MyPolygons unsorted){
//
//        return sorted;
//    }

}
