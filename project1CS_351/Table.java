import java.util.NoSuchElementException;

/**
 * A generic table class to store objects that extend from Contact,
 * allowing for various operations like insertion, deletion, and queries.
 * 
 * @param <T> The type of elements in this table, extending from Contact.
 */
public class Table<T extends Contact> implements Iterable<T> {

   //
    private int size;
    private int modCount = 0;
    private Node<T> head;
    private Node<T> tail;
    private String title;

    
    
    /**
     * Constructs an empty Table.
     */	
    public Table(){
        doClear();
    }

   /**
     * Node class to represent each element in the linked list structure of Table.
     */
    private static class Node<T>{
    	public T nodeData;
    	public Node<T> previous;
    	public Node<T> next;

        /**
 	* Constructs a new node with specified data, previous node, and next node.
 	* 
 	* @param nodeData The data to be stored in this node.
 	* @param previous A reference to the previous node in the list, or null if this is the first node.
 	* @param next A reference to the next node in the list, or null if this is the last node.
 	*/
	public Node(T nodeData, Node<T> previous, Node<T> next){
            	this.nodeData = nodeData; // Assigns the data for this node
    		this.previous = previous; // Link to the previous node in the list
    		this.next = next;         // Link to the next node in the list
        }

        
	    
	
	/**
 	* Returns the data stored in this node.
 	* 
 	* @return The data of this node.
 	*/    
	public T getData(){
            return (this.nodeData);// Returns the data contained in this node
        }


	/**
 	* Returns the previous node linked to this node.
 	* 
 	* @return The previous node in the list, or null if there is no previous node.
 	*/
	    
	public Node<T> getPrevious(){
            return (this.previous);// Returns the link to the previous node
        
        }
	    
	/**
 	* Returns the next node linked to this node.
 	* 
 	* @return The next node in the list, or null if there is no next node.
 	*/
	public Node<T> getNext(){
            return (this.next);
        
        }

    }

   **
   * Resets the table to its initial state.
   * This method initializes the list as empty.
   */
   
 private void doClear(){
    this.head = new Node<>(null, null, null); // Creates a new head node with no data.
       this.tail = new Node<>(null, head, null); // Creates a new tail node and links it with the head.
       this.head.next = tail; // A link from head to tail

       this.size = 0; // Resets the size of the table 
       this.modCount++; // For Iterator check
   }


 /**
 * Method to clear the table, removing all elements.
 */
public void clear() {
    doClear(); // doClear method to reset the table.
}

/**
 * Returns the number of elements stored in the table.
 * 
 * @return The size of the table 
 */
 public int size() {
    return this.size; // Returns the current number of elements in the table.
}

 /**
 * Checks if the table is empty.
 * 
 * @return true if the table has no elements,
 */
public boolean isEmpty() {
    return this.size == 0; // Evaluates to true if size is 0
}

/**
 * Inserts a new element at the end of the table.
 * 
 * @param nodeData The data of the new element to be inserted in this table.
 */
public void insert(T nodeData) {
    add(this.size(), nodeData); // Adds the new element to the end of the table.
}
	
    /**
 * Inserts an element at the passed index within the table.
 * 
 * @param idx The index at which the element is to be inserted.
 * @param nodeData The data of the element to be inserted.
 * @throws IndexOutOfBoundsException if the index is out of range
 */
public void add(int idx, T nodeData) {
    addBefore(getNode(idx, 0, size()), nodeData);
}

/**
 * Checks if a specified element is contained within the table.
 * 
 * @param nodeObject The element to search for within the table.
 * @return true if the element is found, false otherwise.
 */
public boolean contains(T nodeObject) {
    for (T object : this) {
        if (object.compare(nodeObject)) {
            return true;
        }
    }
    return false;
}

/**
 * Difference between this table and another table
 * 
 * @param table The table to compare with this table.
 * @return A new table containing elements of this table but not in other table
 */
public Table<T> difference(Table<? extends Contact> table) {
    Table<T> diffTable = new Table<>();
    for (T item : this) {
        boolean found = false;
        for (Contact contact : table) {
            if (item.compare(contact)) {
                found = true;
                break;
            }
        }
        if (!found) {
            diffTable.insert(item);
        }
    }
    return diffTable;
}

    
    
    /**
 * Selects and returns elements from the table where attribute mathces the given value.
 * 
 * @param attribute The attribute to check against the value.
 * @param value The value to match for the specified attribute.
 * @return A new table containing elements 
 */
public Table<T> select(String attribute, String value) {
    Table<T> selected = new Table<>();
    for (T object : this) {
        if (object.hasValue(attribute, value)) {
            selected.insert(object);
        }
    }
    return selected;
}

/**
 * Eements of this table with another table with no duplicates 
 * 
 * @param otherTable The table to union with this table.
 * @return A new table having the union of elements
 */
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

/**
 * Table containing elements that are common between this table and another table,
 * 
 * @param attribute The attribute to match against the value.
 * @param value The value to match 
 * @param table The table to intersect with this table.
 * @return A new table from instercting of elements 
 */
Table<T> intersect(String attribute, String value, Table<T> table) {
    Table<T> intersectTable = new Table<>();
    for (T item : this) {
        if (table.contains(item) && item.hasValue(attribute, value)) {
            intersectTable.insert(item);
        }
    }
    return intersectTable;
}



    
/**
 * Removes element from the table where attribute matches the given value.
 * 
 * @param attribute The attribute to check against the value.
 * @param value The value to match for the specified attribute.
 */
public void remove(String attribute, String value) {
    Node<T> current = this.head;
    while (current.next != null) {
        current = current.next;
        if (current.nodeData.hasValue(attribute, value)) {
            this.remove(current);
            break;
        }
    }
}



/**
 * Retrieves the element at the specified index in the table.
 * 
 * @param idx The index of the element to retrieve.
 * @return The element at the specified index.
 */
public T get(int idx) {
    return getNode(idx).getData();
}

/**
 * Sets the element in the table with the specified new value.
 * 
 * @param idx The index of the element to replace.
 * @param newValue The new value to be stored at the position.
 * @return The old value
 */
public T set(int idx, T newValue) {
    Node<T> p = getNode(idx);
    T oldValue = p.nodeData;
    p.nodeData = newValue;
    return oldValue;
}

/**
 * Removes  element at a given position in the table.
 * 
 * @param idx The index of the element to be removed.
 * @return The removed element.
 */
public T remove(int idx) {
    return remove(getNode(idx));
}

    
            
    /**
 * Inserts a new node before the specified node in the list
 *
 * @param node The node before which the new node will be inserted.
 * @param nodeData The data for the new node to be inserted.
 */

    private void addBefore(Node<T> node, T nodeData) {
    	
       
        Node<T> newNode = new Node<>(nodeData, node.previous, node);
        
    
        if (node.previous != null) {
     
            node.previous.next = newNode;
        } else {
           
            this.head.next = newNode;
        }
        
       
        node.previous = newNode;
        
        this.size++;
        this.modCount++;
    }

    
   /**
 * Removes the specified node from the list.
 *
 * @param node The node to be removed from the list.
 * @return The data contained in the node that was removed.
 */
private T remove(Node<T> node) {
   
    node.next.previous = node.previous;
    node.previous.next = node.next;
    
   
    this.size--;
    this.modCount++;

   
    return node.getData();
}

/**
 * Retrieves the node at the specified index.
 
 *
 * @param idx The index of the node to retrieve.
 * @return The node at the specified index.
 */
private Node<T> getNode(int idx) {
 
    return getNode(idx, 0, this.size() - 1);
}



    
    /**
 * Retrieves the node at a specified index within a specified range
 * @param idx The index of the node to retrieve.
 * @param lower The lower bound of the index range 
 * @param upper The upper bound of the index range 
 * @return The node at the specified index.
 * @throws IndexOutOfBoundsException If the specified index is out of bounds
 */
private Node<T> getNode(int idx, int lower, int upper) {
    
    Node<T> node;

    
    if (idx < lower || idx > upper) {
        throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds.");
    }

    
    if (idx < size() / 2) {
       
        node = head;
        for (int i = 0; i <= idx; i++) {
            node = node.next;
        }
    } else {
      
        node = tail;
        for (int j = this.size(); j > idx; j--) {
            node = node.previous;
        }
    }

    
    return node;
}




   /**
 * Creates an iterator for iterating over the elements of the table.
 */
public java.util.Iterator<T> iterator() {
    return new TableIterator();
}
    /**
 * Iterator for Table class, allowing sequential access to its elements.
 */
public class TableIterator implements java.util.Iterator<T> {
    
    /**
     * Checks if there are more elements to iterate over.
     * 
     * @return true if there is at least one more element
     */
    public boolean hasNext() {
        return (current != tail && current != null);
    }

    /**
     * Returns the next element in the iteration 
     * Throws NoSuchElementException if there are no more elements.
     * 
     * @return The next element in the iteration.
     * @throws ConcurrentModificationException if object changed outside this iterator.
     * @throws NoSuchElementException if the iteration has no more elements.
     */
    public T next() {
        if (modCount != expectedModCount) {
            throw new java.util.ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T nodeObject = current.getData();
        current = current.next;
        okToRemove = true;
        return nodeObject;
    }



        /**
 * Removes the last element returned by the iterator from the collection
 */
public void remove() {
    if (modCount != expectedModCount) {
        throw new java.util.ConcurrentModificationException();
    }
    if (!okToRemove) {
        throw new IllegalStateException();
    }
    Table.this.remove(current.previous);
    expectedModCount++;
    okToRemove = false;
}


   }
    
    
/**
 * Constructs a string representation of the Table. 
 * @return A single string containing all elements in this table.
 */
@Override
public String toString() {
    String sb = "";
    for (T object : this) {
        sb += object.toString();
    }
    return sb;
}



}
