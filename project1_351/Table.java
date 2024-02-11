public class Table<T extends Contact> implements Iterable<T> {

	
    private int size;
    private int modCount = 0;
    private Node<T> head;
    private Node<T> tail;
    private String title;

    
    public Table(){
        doClear();
    }

    private static class Node<T>{
        public T nodeData;
        public Node<T> previous;
        public Node<T> next;

        public Node(T nodeData,Node<T> previous, Node<T> next){
            this.nodeData = nodeData;
            this.previous = previous;
            this.next = next;
        }

        public T getData(){
            return (this.data);
        }

        public Node<T> getPrevious(){
            return (this.previous);

        }public Node<T> getNext(){
            return (this.next);
        
        }

    }

    public doClear(){
       this.head = new Node(null, null, null);
       this.tail = new Node(null, head, null);
       this.head.next = tail;

       this.size = 0;
       this.modCount++;
   }
    public void clear
    {doClear();}
    public int size(){
        return this.size();
    }
	public boolean isEmpty(){
        return (this size() == 0);
    }
    
    public void insert(T nodeData){
        add(this.size(), node); return true;
    }
	
    public void add(int idx, T nodeData){
        addBefore(getNode(idx,0,size(), nodeObject));}

    public boolean contains(T nodeObject){
        boolean contains = false
        Node current = this.head;
        while(current.next != null){

            current = current.next;
            if(current.getData().equals(nodeObject){

                contains = true;
                break;
            }

        }
            
        return (contains);

    }

    public Table<T> difference(Table<T> table){

        Table<T> newTable = new Table<>();
        Node<T> current = myTable.head;

        while(current.hasNext()){
            
            current = current.next;      
            if(!this.contains(current).getData()){

                newTable.add(current.getData());
            }

        }

        return (newTable);

    }



    public Table<T> union(Table<T> table){

        Table<T> unionTable = table;
        Node<T> current = this.head;
        T data = null;

        while(current.hasNext()){

            current = current.next;
            data = current.data;
            if(!(newTable.contains(data))){

                newTable.add(current.getData());
            }

        }

        return (newTable);

    }


    public Table<T> intersect(String attribute, String value,
    Table<T> table){
        
        Table<T> intersectTable = this.union(table);
        Node<T> current = intersectTable.head;
        T data = null;

        while(current.hasNext()){

            current = current.next;
            current.data.setValue(attribute, value);

        }

        return (intersectTable);

    }
    public void remove(String attribute, String value){


        Node<T> current = this.head;
        T data = null;

        while(current.hasNext()){

            

        }



    public Table<T> select(String attribute, String value){}
        
        Table<T> selectedTable = this;
        Node<T> current = selectedTable.head;
        T data = null;

        while(curent.hasNext()){

            current = current.next;
            current.data.setValue(attribute, value);
        }

        return (selectedTable);

   }
            
    public T get(int idx){
        return (getNode(idx).data;}
    public T set(int idx, T newValue){
        Node<T> p = getNode(idx);
        T oldValue = p.data;
        p.data = newValue;
        return (oldVal);
    }

    public T remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> node, T nodeData){
        Node<T> newNode = new Node<>(nodeData, node.getPrevious, node);
        newNode.previous.next = newNode;
        p.previous = newNode;
        this.size()++;
        this.modCount++;
   }



    private T remove(Node<T> node){
        node.next.previous = node.previous;
        node.previous.next = node.next;
        this.size--;
        this.modCount ++;

        return (node.getData);
    }
    private Node<T> getNode(int idx){
        
        return getNode(idx, 0, this.size() - 1);

    }
    private Node<T> getNode{int idx, int lower, int upper){
        Node<T> node;

        if(idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }

        if(idx < size() / 2){
            node = head;
            for(int i = 0; i < idx; i++){
                node = node.nex;
            }

        }
            
       else{
           node = tail;
           for(i = this.size; i > idx; i++){
               node = node.previous;
            }
       }

       return (this.node);

    }




    public java.util.Iterator<T> iterator(){
        return new TableIterator();
    }

    public class TableIterator  implements java.util.Iterator<T>{
        
        private Node<AnyType> current = head.next;
        private int expectedModCount = this.modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){

            return (current != tail && current!= null);

        }

       public T next(){

           if(modCount != excpectedModCount){
               throw new java.util.ConcurrentModificationException();
           }

           if(!hasNext()){
            
              throw new noSuchElementException();
           }

          T nodeObject = current.data;
          current = current.next;
          okToRemove = true;
          return (nodeObject);

        }

        public void remove(){

            if(modCount != excpectedModCount){                                   
                throw new java.util.ConcurrentModificationException();           
            }

            if(!okToRemove){
                throw new IllegalStateException();
            }

            Table.this.remove(current.previous);
            excpectedModCount ++;
            okToRemove = false;

        }

   }



}
