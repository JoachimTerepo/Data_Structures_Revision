package Revision;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {
    
    int numElements;
    Node frontNode;
    Node rearNode;
    
    public LinkedQueue(){
        numElements = 0;
        frontNode = null;
        rearNode = null;
    }
    
    public void enqueue(E element){ 
        Node<E> newNode = new Node<E>();
        newNode.element = element;
        if (rearNode==null){ 
            frontNode = newNode;
            rearNode = newNode;
        }
        else{ 
            rearNode.next = newNode;
            rearNode = newNode;
        }
        numElements++;
    }
    
    public E dequeue() throws NoSuchElementException{ 
        if (frontNode != null){ 
            E frontElement = (E) frontNode.element;
            frontNode = frontNode.next;
            numElements--;
            if(numElements == 0)
                rearNode = null;
            return frontElement;
        }
        else throw new NoSuchElementException();
    }

    public E first() throws NoSuchElementException{ 
        if (numElements > 0)
            return (E) frontNode.element;
        else throw new NoSuchElementException();
    }
    
    public boolean contains(E o){
        Node current = frontNode;
        for (int i = 0; i < numElements; i++){
            if (current.element.equals(o)){
                return true;
            }
            else{
                current = current.next;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return (numElements < 0);
    }
    
    public int size(){
        return numElements;
    }
    
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("Tupac");
        queue.enqueue("Biggie");
        queue.enqueue("Eminem");
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
        queue.enqueue("J.Cole");
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.contains("J.Cole"));
    }
    
}
