package adt;

import java.util.Iterator;

public interface ListInterface<T> {
    
    public boolean add(T newEntry);
    
    public boolean add(T[] newEntries);
    
    public T remove(int givenPosition);
    
    public boolean contains(T anEntry);
    
    public boolean replace(int givenPosition, T newEntry);
    
    public void clear();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public T getEntry(int givenPosition);
    
    public int getNumberOfEntries();
    
    public Iterator<T> getIterator();
}
