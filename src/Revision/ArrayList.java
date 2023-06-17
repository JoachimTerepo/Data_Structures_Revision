package Revision;

import java.util.NoSuchElementException;

public class ArrayList<E> {
    int numElements;
    E[] elements;
    int INITIAL_CAPACITY = 20;
    
    public ArrayList(){
        numElements = 0;
        elements = (E[])(new Object[INITIAL_CAPACITY]);
    }
    
    public boolean add(E o){
        elements[numElements] = o;
        numElements++;
        return true;
    }
    
    public E get(int index){
        if (index >= 0 && index < numElements){ 
            E element = elements[index];
            return element;
        }
        else
            throw new NoSuchElementException("index out of bounds");
    }
    
    public E remove(int index){
        if (index >= 0 && index < numElements){
           E element = elements[index];
           elements[index] = null;
           for (int i = index; i < numElements; i++){
               elements[i] = elements[i+1];
           }
           elements[numElements - 1] = null;
           numElements--;
           return element;
        }
        return null;
    }
    
    public boolean contains(E o){
        for (int i = 0; i < numElements; i++){
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return (numElements == 0);
    }
    
    public int size(){
        return numElements;
    }
    
    public int search(String[] pool, String target){ 
        boolean found = false;
        int index = 0;
        while (!found && index<pool.length){ 
            if(target.equals(pool[index]))
                found = true;
            else
                index++;
        }
        if(!found)
            index = -1;
        return index;
}
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Tupac");
        list.add("Biggie");
        list.add("J.Cole");
        System.out.println(list.remove(1));
        System.out.println(list.contains("Biggie"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
