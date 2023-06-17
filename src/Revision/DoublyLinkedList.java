package Revision;

public class DoublyLinkedList<E> {
    Node head;
    int numElements;
    
    public DoublyLinkedList(){
        this.head = null;
        this.numElements = 0;
    }
    
    public boolean add(E o){
        Node newNode = new Node();
        newNode.element = o;
        Node current = this.head;
        if(this.head == null){
            this.head = newNode;
            numElements++;
            return true;
        }
        else{
            for (int i = 0; i < numElements; i++){
                if (current.next == null){
                    current.next = newNode;
                    newNode.prev = current;
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
        Node current = head;
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
        Node current = head; 
        if (this.head.element.equals(o)){
            head = head.next;
            numElements--;
            return true;
        }
        else{
            for (int i = 0; i < numElements; i++){
                if (current.next.element.equals(o)){
                    current.next = current.next.next;
                    current.next.next.prev = current;
                    current.next = null;
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
    
    public E contains(E o){
        Node current = head;
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
    
    //Returns a boolean, If the numElements = 0, that means there is nothing stored in the arraylist.
    //Thus, returning 0.
    public boolean isEmpty(){
        return (numElements == 0);
    }
    
    //Return's the number of elements, not the size of the array.
    public int size() {
        return numElements;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList rappers = new DoublyLinkedList();
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
