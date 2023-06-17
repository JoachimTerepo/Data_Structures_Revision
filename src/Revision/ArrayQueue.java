package Revision;

public class ArrayQueue<E> {
    
    E[] elements;
    int numElements;
    int INITIAL_CAPACITY = 20;
    
    public ArrayQueue(){ 
        numElements = 0;
        elements = (E[])(new Object[INITIAL_CAPACITY]);
    }
    
    public boolean enqueue(E o){
        if (numElements == 0){
            elements[0] = o;
            numElements++;
            return true;
        }
        else{
            elements[numElements] = o;
            numElements++;
            return true;
        }
    }
    
    public E dequeue(){
        E element = elements[0];
        elements[0] = null;
        for (int i = 0; i < numElements; i++){
            elements[i] = elements[i+1];
        }
        numElements--;
        return element;
    }
    
    public E first(){
        return elements[0];
    }
    
    public boolean isEmpty(){
        return (numElements < 0);
    }
    
    public int size(){
        return numElements;
    }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue("Tupac");
        queue.enqueue("Biggie");
        queue.enqueue("Eminem");
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
        queue.enqueue("J.Cole");
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
