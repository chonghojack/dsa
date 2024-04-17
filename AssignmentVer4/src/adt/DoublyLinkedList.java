package adt;

//doubly linked list

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>{
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;
    
    //linked list constructor
    public DoublyLinkedList() {
        clear();
    }
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if(isEmpty()){
            firstNode = newNode;
            lastNode = firstNode;
        }
        else{
            lastNode.next = newNode;
            lastNode.next.before = lastNode;
            lastNode = newNode;
            lastNode.next = null;
        }
        
        numberOfEntries++;
        
        return true;
    }
    
    //add many entry in a list
    @Override
    public boolean add(T[] newEntries){
        for(int i = 0; i < newEntries.length; i++){
            add(newEntries[i]);
        }        
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T item = null;
        
        // CASE 1 : item in first node
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            if(givenPosition == 1){
                item = firstNode.data;
                firstNode = firstNode.next;
                firstNode.before = null;
            }
            
            // CASE 2 : item in last node
            else if(givenPosition == numberOfEntries){
                item = lastNode.data;
                lastNode = lastNode.before;
                lastNode.next = null;
            }
            //CASE 3 : item in middle
            else {                       
            Node nodeBefore = firstNode;
            for (int i = 1; i < givenPosition - 1; ++i) {
              nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
            }
            item = nodeBefore.next.data;  // save entry to be removed
            nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            nodeBefore.next.before = nodeBefore;
          }
        }
        
        numberOfEntries--;
        
        return item;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
          if (anEntry.equals(currentNode.data)) {
            found = true;
          } else {
            currentNode = currentNode.next;
          }
        }
        return found;  
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false; //linked list is infinite
    }

    @Override
    public T getEntry(int givenPosition) {
        T item = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
          Node currentNode = firstNode;
          for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          item = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return item;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    @Override
    public String toString() {
        String outputStr = "";
        if(!isEmpty()){
            Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
    }
      
      return outputStr;
    }
    
    //iterator
    @Override
    public Iterator<T> getIterator(){
      return new ListIterator();
    }
  
    private class ListIterator implements Iterator<T>{
        private Node currentNode = firstNode;
      
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list.");
            }

            T currentData = currentNode.data;
            currentNode = currentNode.next;
            return currentData;
        }   

        public boolean hasNext(){
            return currentNode != null;
        }
    }
    
    //node class
    private class Node {
        private T data;
        private Node next;
        private Node before;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.before = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
            this.before = null;
        }
        
        private Node(T data, Node next, Node before) {
            this.data = data;
            this.next = next;
            this.before = before;
        }
    }
    
}
