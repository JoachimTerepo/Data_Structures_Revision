package Revision;

import java.util.NoSuchElementException;

public class LinkedStack<E> {
    
    int numElements;
    Node firstNode;
    
    public LinkedStack(){ 
        numElements = 0;
        firstNode = null;
    }
    
    //push adds an element to the top of the stack as a new node and increases numElements.
    //Then moves the firstNode to the newNode.
    public void push(E element){ 
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = firstNode;
        firstNode = newNode;
        numElements++;
    }
    
    //pop removes the top element from the stack by shifting firstNode along its next link and decreases numElements
    public E pop() throws NoSuchElementException{ 
        if (firstNode != null){ 
            E topElement = (E) firstNode.element;
            firstNode = firstNode.next;
            numElements--;
            return topElement;
        }
        else throw new NoSuchElementException();
    }
    
    public E peek() throws NoSuchElementException{ 
        if (numElements > 0)
            return (E) firstNode.element;
        else throw new NoSuchElementException();
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
        Node currentNode = firstNode;
        while (currentNode != null){ 
            output += currentNode.element;
            if (currentNode.next != null)
                output += ",";
            currentNode = currentNode.next;
        }
        output += "]";
        return output;
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
