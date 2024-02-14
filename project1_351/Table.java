package project1CS_351;

import java.util.NoSuchElementException;
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
            return (this.nodeData);
        }

        public Node<T> getPrevious(){
            return (this.previous);
        
        }public Node<T> getNext(){
            return (this.next);
        
        }

    }


	private void doClear(){
       this.head = new Node<T>(null, null, null);
       this.tail = new Node<T>(null, head, null);
       this.head.next = tail;

       this.size = 0;
       this.modCount++;
   }
    public void clear()
    {doClear();}
    
    public int size(){
        return this.size;
    }
    
	public boolean isEmpty(){
        return (this.size() == 0);
    }
    
    public void insert(T nodeData){
        add(this.size(), nodeData); 
    }
	
    public void add(int idx, T nodeData){
    	
        addBefore(getNode(idx, 0, size()), nodeData);
        
    }

    public boolean contains(T nodeObject) {
        for (T object : this) {
            if (object.compare(nodeObject)) {
                return true;
            }
        }
        return false;
    }

    public Table<T> difference(Table<? extends Contact> table) {
        Table<T> diffTable = new Table<>();
        for (T item : this) {
            boolean found = false;
            for (Contact contact : table) {
                if ((item.compare(contact))) {
                    found = true;
                    break;
                }else {
                	found = false;
                }
            }
            if (!found) {
                diffTable.insert(item);
            }
        }
        return diffTable;
    }
    
    
    
    public Table<T> select(String attribute, String value){
    	Table<T> selected = new Table<>();
    	
    	for(T object: this) {
    		if(object.hasValue(attribute, value)) {
    			selected.insert(object);
    		}
    	}
    	
    	return (selected);
    }


    public Table<T> union(Table<? extends Contact> otherTable) {
        Table<T> unionTable = new Table<>();

        
        for (T item : this) {
            unionTable.insert(item);
        }

        
        for (Contact contact : otherTable) {
            @SuppressWarnings("unchecked")
			T item = (T) contact; 
            if (!unionTable.contains(item)) {
                unionTable.insert(item);
            }
        }

        return unionTable;
    }


    Table<T> intersect(String attribute, String value, Table<T> table) {
        
    	Table<T> intersectTable = new Table<>();
        for (T item : this) {
            if (table.contains(item) &&
            		item.hasValue(attribute, value)) {
                intersectTable.insert(item);
            }
        }
        return intersectTable;
    }


    


    
    
    public void remove(String attribute, String value){


        Node<T> current = this.head;

        while(current.next !=null){

			current = current.next;
			if(current.nodeData.hasValue(attribute, value)){
	
				this.remove(current);
				break;

			}

        }
        
        
    }



    
            
    public T get(int idx){
        return (getNode(idx).getData());}
    
    
    public T set(int idx, T newValue){
    	
        Node<T> p = getNode(idx);
        T oldValue = p.nodeData;
        p.nodeData = newValue;
        return (oldValue);
    }

    public T remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> node, T nodeData) {
    	
        // Create a new node that links to 'node' and 'node's previous node
        Node<T> newNode = new Node<>(nodeData, node.previous, node);
        
        // Link the new node into the list
        if (node.previous != null) {
            // Node is not the first real node (right after head), link 'node.previous' to 'newNode'
            node.previous.next = newNode;
        } else {
            // If 'node' is the first real node (right after head), update 'head.next' to point to 'newNode'
            this.head.next = newNode;
        }
        
        // Make node point back to newNode
        node.previous = newNode;
        
        this.size++;
        this.modCount++;
    }

    



    private T remove(Node<T> node){
        node.next.previous = node.previous;
        node.previous.next = node.next;
        this.size--;
        this.modCount ++;

        return (node.getData());
    }
    
    private Node<T> getNode(int idx){
        
        return getNode(idx, 0, this.size() - 1);

    }
    private Node<T> getNode(int idx, int lower, int upper){
        	
        Node<T> node;

        if(idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }

        if(idx < size() / 2){
            node = head;
            for(int i = 0; i < idx; i++){
                node = node.next;
            }

        }
            
       else{
           node = tail;
           for(int j = this.size(); j > idx; j++){
               node = node.previous;
            }
       }

       return (node);

    }




    public java.util.Iterator<T> iterator(){
        return new TableIterator();
    }

    public class TableIterator implements java.util.Iterator<T>{
        
        private Node<T> current = head.next;
        private int expectedModCount = Table.this.modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){

            return (current != tail && current!= null);

        }

       public T next(){

           if(modCount != expectedModCount){
               throw new java.util.ConcurrentModificationException();
           }

           if(!hasNext()){
            
              throw new NoSuchElementException();
           }

          T nodeObject = current.getData();
          current = current.next;
          okToRemove = true;
          return (nodeObject);

        }

        public void remove(){

            if(modCount != expectedModCount){                                   
                throw new java.util.ConcurrentModificationException();           
            }

            if(!okToRemove){
                throw new IllegalStateException();
            }

            Table.this.remove(current.previous);
            expectedModCount ++;
            okToRemove = false;

        }

   }
    
    
   @Override
   public String toString() {
	   String sb = "";
	  
	   for(T object : this) {
		   sb += object.toString();
		
	   }
	   
	   return (sb);
   }



}
