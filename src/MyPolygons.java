public class MyPolygons {
    private Node sentinel;
    private Node current;

    MyPolygons(){
        sentinel = new Node();
        current = null;
    }

    //prepend items into the start of the list

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
        if(sentinel.getPrevious()!=null){
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
        reset();
        //create new Node, add item to new Node
        Node newNode = new Node(item);
        //loop to find place
        while(current.getObj() != place) {      //test if current holds place   TODO: operator overloading???
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

    //step to the next item

    public void next(){
        current = current.getNext();
    }

    //reset current to the head of the list

    public void reset(){
        current = sentinel;
    }

    //remove an item from the head of the list

    public String remove(){
        //create holding polygon
        Polygon holding = new Polygon();
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
        //the detached Node should be deleted by  garbage collector


        return holding.toString(); //possible break in encapsulation here
    }

    public String printing(){

        String str="";

        reset();
        next();
        while(current.getObj()!=null){
            str += current.getObj().toString();
            str += "\n";
            next();
        }

        return str;
    }

}
