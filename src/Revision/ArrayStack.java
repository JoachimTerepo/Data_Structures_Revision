package Revision;

import java.util.NoSuchElementException;

public class ArrayStack<E> {
    //A stack is a linear collection of objects that are inserted and removed according to the LIFO (last-in-first-out) principle (or FILO first-in-last-out).
    //NOTE: Only allowed to add and remove elements from the top of the stack! i.e. cannot remove element from the middle.
    
    E[] elements;
    int numElements;
    int INITIAL_CAPACITY = 20;
    
    public ArrayStack(){ 
        numElements = 0;
        elements = (E[])(new Object[INITIAL_CAPACITY]);
    }
    
    //push adds an element to the top of the stack and increases the numElements field. 
    //It must also check to make sure that the array has enough room to accommodate the new element.
    public void push(E element){ 
        if(numElements >= elements.length){
            expandCapacity();
        }
        elements[numElements++] = element;
    }
    
    //pop removes the top element from the stack and decreases the numElements field.
    public E pop() throws NoSuchElementException{ 
        if (numElements > 0){ 
            E topElement = elements[numElements-1];
            elements[numElements-1] = null;
            numElements--;
            return topElement;
        }
        else
            throw new NoSuchElementException();
    }
    
    //peek simply returns the element on top of the stack .
    public E peek() throws NoSuchElementException{ 
        if (numElements > 0)
            return elements[numElements-1];
        else
            throw new NoSuchElementException();
    }
    
    //isEmpty simply returns true if the number of elements in the stack is 0.
    public boolean isEmpty(){ 
        return (numElements==0);
    }
    
    //size returns the number of elements
    public int size(){ 
        return numElements;
    }

    //toString print out the elements in the stack from top to bottom
    public String toString(){ 
        String output = "[";
        for (int i=numElements-1; i>=0; i--){ 
            output += elements[i];
        if (i>0)
            output += ",";
        }
        output += "]";
        return output;
    }
    
    private void expandCapacity(){ 
        E[] largerArray =(E[])(new Object[elements.length*2]);
        // copy the elements array to the largerArray
        for (int i=0; i<numElements; i++){
            largerArray[i] = elements[i];
        }
        elements = largerArray;
    }
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push("Tupac");
        stack.push("Biggie");
        stack.push("Eminem");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push("J.Cole");
        System.out.println(stack.size());
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
    }
}
