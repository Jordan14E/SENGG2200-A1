/**
 * Author: Jordan Eade
 * SENGG 2200 Assessment 1
 *  The Node class is used to define the basic element of the data structure used in this project.
 *  The Node contains a reference to the next node in the order, a reference to the previous node in the order,
 *  as well as holding an object.The Node class is able to return the reference to the next or previous node
 *  or the object it is holding.
 */

public class Node {
    private Polygon obj;
    private Node next;
    private Node previous;
    //constructor
    Node(){
        obj = null;
        next = null;
        previous = null;
    }

    //constructor
    Node(Polygon data){
        obj = data;
        next = null;
        previous = null;
    }

    //getters and setters
    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public Polygon getObj() {
        return obj;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
