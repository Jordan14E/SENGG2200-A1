public class MyPolygons {
    private Node sentinel;
    private Node current;

    //prepend items into the start of the list

    public void prepend(Polygon item){

        //move current to sentinel
        reset();
        //create new Node, add item to Node
        Node newNode = new Node(item);
        //link item to sentinel.getNext() if any
        if(sentinel.getNext().getObj()!=null){
            newNode.setNext(sentinel.getNext());
            sentinel.getNext().setPrevious(newNode);
        }
        else{
            newNode.setNext(sentinel);
            sentinel.setPrevious(newNode);
        }
        //make item sentinel's next
        newNode.setPrevious(sentinel);
        sentinel.setNext(newNode);
    }

    //append items to the back of the list

    public void append(Polygon item){

        //move current to sentinel
        reset();
        //create new Node, add item to Node
        Node newNode = new Node(item);
        //link item to sentinel.getPrevious() if any
        if(sentinel.getPrevious().getObj()!=null){
            sentinel.getPrevious().setNext(newNode);
            newNode.setPrevious(sentinel.getPrevious());
        }
        else{
            sentinel.setNext(newNode);
            newNode.setPrevious(sentinel);
        }
        //make item sentinel's previous
        sentinel.setPrevious(newNode);
        newNode.setNext(sentinel);
    }

    //insert items BEFORE a specified item

    public void insert(Polygon place, Polygon item){

        //move current to sentinel

        //loop to find place
            //move current to next
            //test if current holds place   TODO: operator overloading???

        //link item to place's previous

        //make item place's previous

    }

    //step to the next item

    public void next(){
        current = current.getNext();
    }

    //reset current to the head of the list

    public void reset(){
        current = sentinel;
    }

    //remove an item from the head of the list

    public Polygon remove(){
        //TODO: ask about having to return polygon

        return ;
    }

}
