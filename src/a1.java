/**
 * Author: Jordan Eade
 * SENGG 2200 Assessment 1
 * The a1 class is teh main class for this project. It holds the main run method, teh unsorted() method and the sorted()
 * method. all input and output takes place in this class through the use of the system interface and the
 * java.util.Scanner library
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class a1 {

    /**
     *Main method for the project, is the entry point
     */
    public static void main(String[] args){

        //give directions for user to input file name
        System.out.println("Please enter the name of the file you want to read from including the proper extension. \n" +
                "E.g. '.txt':\n");
        //create Scanner to read in from System.in
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        //creating File to open the filename from user input
        File file = new File(fileName);
        Scanner input = null;
        //try catch block for file not found exception handling
        try{
            input = new Scanner(file);
        }
        catch(FileNotFoundException f){
            System.out.println("File could not be found.");
        }

        MyPolygons list = new MyPolygons();
        //calls unsorted method to fill list with input from file
        list= unsorted(list,input);
        System.out.println("unsorted list:\n"+list.printing()+"\n");
        //calls sorted to order the unsorted list
        list = sorted(list);
        System.out.println("sorted list:\n"+list.printing());

    }

    /**
     * The unsorted() method is used to read polygons in from the file input and fill out the data structure. It does
     * this using a loop to move through each polygon in the file with the format
     * "P 'numeber of sides' 'x-cordinate y- coordinate separated by a space'"
     * The usorted method puts the number of sides into an integer and creates an array of Points which is then passed
     * to the MyPolygons.append() method to be added in order of the file input.
     * @param unsorted teh list to add polygons to
     * @param input the scanner saet up to read from the file
     * @return A MyPolygons data structure filled with the input from the file
     */
    public static MyPolygons unsorted(MyPolygons unsorted, Scanner input){

        //while still something in the file and the next character is a "P"
        while(input.hasNextLine() && input.next().equals("P")){
            //put the number of sides into an integer
            int vertices = input.nextInt();
            //number of sides plus one, so that the last index can be the same point as the first
            Point[] points = new Point[vertices+1];
            double x, y;
            //taking the points from the file
            for(int i=0; i<vertices;i++){
                x = input.nextDouble();
                y = input.nextDouble();
                points[i] = new Point(x,y);
            }
            //adding the last point to be the same as the first
            points[vertices] = new Point(points[0].getX(), points[0].getY());
            //create new polygon with the array of points and number of sides from the file input
            Polygon p = new Polygon(vertices, points);
            //append to list
            unsorted.append(p);
        }

        return unsorted;
    }

    /**
     * The sorted() method is used to take an unsorted MyPolygons list and order it. It does this by taking from the
     * front of the unsorted list passed and calling the MyPolygons.inOrder() method to place the polygon in the correct
     * position. The first polygon to be added to the sorted list does not need to be ordered so is placed in the sorted
     * list using MyPolygons.append()
     * @param unsorted The unsorted MyPolygons list to be ordered
     * @return The sorted MyPolygons list
     */
    public static MyPolygons sorted(MyPolygons unsorted){

        MyPolygons sorted = new MyPolygons();
        //add the first polygon to the sorted list without ordering
        sorted.append(unsorted.remove());

        //loop through the rest of the unsorted list, adding each polygon to the sorted list using inOrder()
        while(!unsorted.isEmpty()){
            sorted.inOrder(unsorted.remove());
        }


        return sorted;
    }

}

