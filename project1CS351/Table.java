package project1CS351;

import java.util.Iterator;

public class Table<T extends Contact> {
	private Node head;  //First record in the table
	private Node tail;  //Last record in the table
	private String title; //Label for the table
	//... 

	class Node{
		
		private T data;
		private Table<T>.Node next;
		
		private Node(T data){
			
			this.data = data;
			this.next = null;
		}
		
		private Node(T data, Table<T>.Node nextNode) {
			this.data = data;
			this.next = nextNode;
		}
		
		public T getData() {
			return (this.data);
		}
		
		public Table<T>.Node getNextNode() {
			return (this.next);
		}
		
		private void setData(T data) {
			this.data = data;
		}
		
		private void setNextNode(Table<T>.Node next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return (data.toString());
		}
		
	}
	
	class TIterator implements Iterable<T>{

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
}



