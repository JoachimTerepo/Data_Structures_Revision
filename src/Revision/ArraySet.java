package Revision;

import java.util.AbstractSet;
import java.util.Iterator;

public class ArraySet<E> extends AbstractSet<E>{
    //ArraySets
    //
    //Sets in general are a collection of elements which does not allow duplicates, and usually does not preserve the order of which the element is added to.
    //Array Sets have different variables and implements methods from the AbstractSet class.

    E[] elements;
    int numElements;
    int INITIAL_CAPACITY = 20;

    public ArraySet(){ 
        numElements = 0;
        elements = (E[])(new Object[INITIAL_CAPACITY]);
    }
    
    //How this works is by going through the set and checking if there's a duplicate.
    //If there is, it returns false and doesn't add it to the set.
    //Sets are non duplicates.
    //If there is no duplicates, it will then add to the arrayset.
    //Time complexity: O(n).
    public boolean add(E o){
        if(contains(o)){
            return false;
        }
        elements[numElements] = o;
        numElements++;
        return true;
    }
    
    //Remove method creates new variables to find the correct element to remove.
    //It then iterates throughout the list and checks if the element exist. 
    //If it does, it saves the index and turns found boolean true.
    //If found, It starts the process of removing the element selected.
    //It sets the element thats being removed index with the element at the end.
    //After that, the element at the end is removed.
    //Time Complexity: O(n).
    public boolean remove(Object o){
        int index = 0;
        boolean found = false;
        for (int i = 0; i < numElements && !found; i++){
            if (elements[i].equals(o)){
                index = i;
                found = true;
            }
        }
        if (found){
            elements[index] = elements[numElements - 1];
            elements[numElements - 1] = null;
            numElements--;
        }
        return found;
    }
    
    //This iterates through the list, and returns true if the object exist.
    //If not it returns false.
    //Time Complexity: O(n)
    public boolean contains(Object o){
        for (int i = 0; i < numElements; i++){
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    
    //Returns the element that the user asked for.
    public E get(int i){
        return elements[i];
    }
    
    //Returns a boolean, If the numElements = 0, that means there is nothing stored in the arraylist.
    //Thus, returning 0.
    public boolean isEmpty(){
        return (numElements == 0);
    }
    
    //Return's the number of elements, not the size of the array.
    @Override
    public int size() {
        return numElements;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    
    public static void main(String[] args) {
        ArraySet<String> rappers = new ArraySet<String>();
        rappers.add("Tupac");
        rappers.add("Eminem");
        rappers.add("Tupac");
        rappers.add("Biggie");
        System.out.println(rappers.get(0));
        System.out.println(rappers.isEmpty());
        System.out.println(rappers.size());
        rappers.remove("Tupac");
    }
}
