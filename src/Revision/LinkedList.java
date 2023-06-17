package Revision;

import java.util.Iterator;
import java.util.List;

public class LinkedList<E> {
    
    Node head;
    int numElements;
    
    public LinkedList(){
        head = null;
        numElements = 0;
    }
    
    public boolean add(E o){
        Node newNode = new Node();
        newNode.element = o;
       if (head == null){
           head = newNode;
           numElements++;
           return true;
       }
       else{
           Node current = head;
           for (int i = 0; i < numElements; i++){
            if (current.next == null){
                current.next = newNode;
                numElements++;
                return true;
            }
            else{
               current = current.next;
            }
           }
       }
       return false;
    }
    
    public E get(E o){
        Node<E> current = new Node();
        current = head;
        for (int i = 0; i < numElements; i++){
            if (current.element.equals(o)){
                return (E) current.element;
            }
            else{
                current = current.next;
            }
        }
        return null;
    }
    
    public boolean remove(E o){
        Node<E> current = new Node();
        current = head;
        if (head.element.equals(o)){
            head = head.next;
            numElements--;
            return true;
        }
        else{
            for (int i = 0; i < numElements; i++){
                if (current.next.element.equals(o)){
                    current.next = current.next.next;
                    numElements--;
                    return true;
                }
                else{
                    current = current.next;
                }
            }
        }
        return false;
    }
    
    public boolean contains(E o){
        Node current = new Node();
        current = head;
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
    
    //Returns a boolean, If the numElements = 0, that means there is nothing stored in the arraylist.
    //Thus, returning 0.
    public boolean isEmpty(){
        return (numElements == 0);
    }
    
    //Return's the number of elements, not the size of the array.
    public int size() {
        return numElements;
    }
    
    public boolean search(List<E> pool, E target){ 
        Iterator<E> iterator = pool.iterator();
        boolean found = false;
        while (!found && iterator.hasNext()){ 
            if(target.equals(iterator.next()));
            found = true;
        }
        return found;
}

    
    public static void main(String[] args) {
        LinkedList rappers = new LinkedList();
        rappers.add("Tupac");
        rappers.add("Eminem");
        rappers.add("Tupac");
        rappers.add("Biggie");
        System.out.println(rappers.get("Tupac"));
        System.out.println(rappers.isEmpty());
        System.out.println(rappers.size());
        rappers.remove("Tupac");  
    }
}
