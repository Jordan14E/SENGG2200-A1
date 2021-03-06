/**
 * Author: Jordan Eade
 * SENGG 2200 Assessment 1
 * The MyPolygons class holds all information and methods needed for a circular doubly linked list.
 * The linked list includes a single sentinel node and a reference current that is used to move through the list.
 * The MyPolygons class has the following methods
 * - prepend() adds a polygon to the front
 * - append() adds a polygon to the end
 * - insert() adds a polygon in front of another specified polygon
 * - next() moves to the next node in the list
 * - reset() moves back to the start of the list
 * - remove() returns then deletes a specified polygon
 * - printing() creates a string with all data in MyPolygons instance
 * - isEmpty() returns true if the list is empty
 * - inOrder() assists in ordering MyPolygons instance by finding the item a polygon comes before to pass to insert()
 */

public class MyPolygons {
    //private members
    private Node sentinel;
    private Node current;

    //default constructor
    MyPolygons(){
        sentinel = new Node();
        current = null;
    }


    /**
     * The prepend() method is used to add a polygon to the beginning of the list. It works by moving to the
     * sentinel node and adding it as sentinel's next node. The item is then connected to the next existing
     * polygon or in the case of it being the first polygon added, back to the sentinel to create the circular
     * linked list.
     * @param item the polygon to be added to the list
     */
    public void prepend(Polygon item){

        //move current to sentinel
        reset();
        //create new Node, add item to Node
        Node newNode = new Node(item);
        //link item to sentinel.getNext() if any
        if(sentinel.getNext()!=null){
            newNode.setNext(sentinel.getNext());
            sentinel.getNext().setPrevious(newNode);
        }
        //first node added, make circular structure
        else{
            newNode.setNext(sentinel);
            sentinel.setPrevious(newNode);
        }
        //make item sentinel's next
        newNode.setPrevious(sentinel);
        sentinel.setNext(newNode);
    }


    /**
     * The append() method is used to add a polygon to the end of the list. It works by moving to the
     * sentinel node and adding it as sentinel's ppervious node. The item is then connected to the previous existing
     * polygon or in the case of it being the first polygon added, back to the sentinel to create the circular
     * linked list.
     * @param item The item to be added to the end of the list
     */
    public void append(Polygon item){

        //move current to sentinel
        reset();
        //create new Node, add item to Node
        Node newNode = new Node(item);
        //link item to sentinel.getPrevious() if any
        if(sentinel.getPrevious()!=null){
            sentinel.getPrevious().setNext(newNode);
            newNode.setPrevious(sentinel.getPrevious());
        }
        //first node added, connect back to sentinel to create circular structure
        else{
            sentinel.setNext(newNode);
            newNode.setPrevious(sentinel);
        }
        //make item sentinel's previous
        sentinel.setPrevious(newNode);
        newNode.setNext(sentinel);
    }


    /**
     * The insert() method is used to add a polygon in front of another specified polygon. It works by moving
     * through the linked list and comparing each polygon the list holds to the passed polygon until it finds
     * one that matches. The new polygon is then slotted in and connected to nodes next and previous
     * @param place The polygon already in the list that the new polygon will be in front of
     * @param item The new polygon to add to the list
     */
    public void insert(Polygon place, Polygon item){

        //move current to sentinel
        reset();
        //create new Node, add item to new Node
        Node newNode = new Node(item);
        //loop to find place
        while(current.getObj() != place) {      //test if current holds place
            //move current to next
            next();
        }
        //link item to place's previous
        current.getPrevious().setNext(newNode);
        newNode.setPrevious(current.getPrevious());
        //make item place's previous
        newNode.setNext(current);
        current.setPrevious(newNode);
    }

    /**
     * The next() method is used to iterate through the list by moving the current reference to the next node
     */
    public void next(){
        current = current.getNext();
    }

    /**
     * The reset method is used to move back to the start of the list by moving the current reference to
     * the sentinel node
     */
    public void reset(){
        current = sentinel;
    }


    /**
     * The remove method is used to return the polygon  at the start of the list and then delete it from the
     * data structure. It does this by disconnecting all references to the object and allowing the java garbage
     * collector to delete the memory on its next sweep.
     * @return Polygon that has been removed
     */
    public Polygon remove(){
        //create holding polygon
        Polygon holding = null;
        //move current to sentinel
        reset();
        //move current to next
        next();
        //set holding polygon to current's item
        holding = current.getObj();
        //detach current
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        current.setNext(null);
        current.setPrevious(null);
        reset();
        //the detached Node should be deleted by the garbage collector


        return holding;
    }

    /**
     * The printing() method is used to call the toString() method of every polygon in the MyPolygons
     * data structure. It does this using a for loop to move through the list while appending each toString()
     * return to a string
     * @return string that is the collection of all polygons in the data structure
     */
    public String printing(){

        String str="";
        //move to start of linked list
        reset();
        next();
        //loop through data structure and concatenate each polygon's toString() result
        while(current.getObj()!=null){
            str += current.getObj().toString();
            str += "\n";
            next();
        }

        return str;
    }

    /**
     * The isEmpty() method is used to find whether the data structure is empty. If sentinel is the only node
     * in the data structure then isEmpty() will return true
     * @return
     */
    public boolean isEmpty(){
        //if sentinel has no next node
        if(sentinel.getNext()==null){
            return true;
        }
        //if sentinel's next node has no object (it will be a sentinel)
        else if(sentinel.getNext().getObj()==null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The inOrder() method is used to find teh correct position in the data structure for a polygon. It uses
     * the comesBefore() method to compare the polygons and moves through the list until it finds a polygon in the
     * structure that is larger. It then calls the insert() method.
     * @param item item to be added to the list in order
     */
    public void inOrder(Polygon item){

        boolean found=false;
        //moving to start of list
        reset();
        next();
        //while still looking for position
        while(!found){
            //if current's object is null, it has reached the end of the list and needs to be added to the end of the list
            if(current.getObj()==null){
                found = true;
            }
            //if current comes before the item in order then move to next item
            else if(current.getObj().ComesBefore(item)){
                next();
            }
            else{
                found = true;
            }
        }
        insert(current.getObj(), item);
    }

}
