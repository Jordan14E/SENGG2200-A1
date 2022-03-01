public class Node {
    private Point obj;
    private Node next;
    private Node previous;

    Node(){
        obj = null;
        next = null;
        previous = null;
    }

    Node(Point data){
        obj = data;
        next = null;
        previous = null;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public Point getObj() {
        return obj;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
