public class Node {
    private Polygon obj;
    private Node next;
    private Node previous;

    Node(){
        obj = null;
        next = null;
        previous = null;
    }

    Node(Polygon data){
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
