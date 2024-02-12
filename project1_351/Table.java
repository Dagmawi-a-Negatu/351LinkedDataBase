package project1CS351;

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

    @SuppressWarnings("unchecked")
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
        return this.size();
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

    public boolean contains(T nodeObject){
        boolean contains = false;
        Node<T> current = this.head;
        while(current.next != null){

            current = current.next;
            if(current.getData().equals(nodeObject)){

                contains = true;
                break;
            }

        }
            
        return (contains);

    }

    public Table<T> difference(Table<T> table){

        Table<T> newTable = new Table<>();
        Node<T> current = newTable.head;
        T object = null;
        
		
		//Iterate though each item of the FruitBasket and print them

        while(current.next != null){
            
            current = current.next;
            object = current.getData();
            if(!this.contains(object)){

                object = current.getData();
            	newTable.insert(object);
            }

        }

        return (newTable);

    }



    public Table<T> union(Table<T> table){

        Table<T> unionTable = table;
        Node<T> current = this.head;
        T data = null;

        while(current.next != null){

            current = current.next;
            data = current.getData();
            if(!(unionTable.contains(data))){

                unionTable.insert(current.getData());
            }

        }

        return (unionTable);

    }


    public Table<T> intersect(String attribute, String value,
    Table<T> table){
        
        Table<T> intersectTable = this.union(table);
        Node<T> current = intersectTable.head;
        

        while(current.next != null){

            current = current.next;
            current.nodeData.setValue(attribute, value);

        }

        return (intersectTable);

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



    public Table<T> select(String attribute, String value){
        
        Table<T> selectedTable = this;
        Node<T> current = selectedTable.head;
        T data = null;

        while(current.next != null){

            current = current.next;
            current.nodeData.setValue(attribute, value);
        }

        return (selectedTable);

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

    private void addBefore(Node<T> node, T nodeData){
        Node<T> newNode = new Node<>(nodeData, node.getPrevious(), node);
        newNode.previous.next = newNode;
        newNode.previous = newNode;
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



}
