package Revision;

public class LinkedSet<E>{
    
    Node firstNode;
    int numElements;

    public LinkedSet(){ 
        numElements = 0;
        firstNode = null;
    }
    
    //Implementing a link system is easy.
    //First we need to create a node class to link the set.
    //This is still a set, which means we still have to follow the rules of a set.
    //NO DUPLICATES!!!
    //For our add method, we create a newNode on which we will use to create our link set.
    //We then start off by checking if the first node is null.
    //If it is, we set the firstNode of our linkedset as the newNode.
    //If not, we traverse through the linkedset.
    //If there is a node that contains the same element, it will then return false doing nothing to the linkedset.
    //If not, it will then add the newNode to the end of the linked set, since order does not matter in a set.
    //Time Complexity: O(n)
    public boolean add(E o){
        Node<E> newNode = new Node();
        newNode.element = o;
        if (firstNode == null){
            firstNode = newNode;
            firstNode.element = o;
            numElements++;
            return true;
        }
        Node<E> current = new Node();
        current = this.firstNode;
        if (contains(o)){
            return false;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        numElements++;
        return true;
    }
    
    //For the remove method, we create a current node to store the location of the node we are traversing through.
    //We check if the first node element equals the user input.
    //If it does, we remove it by having the firstNode turn into the next Node of the firstNode.
    //If not, we traverse through the set till we find one.
    //If we find a match, we then remove the node by linking the next node to the next node of that which removes the Node we want to get rid of.
    //If we don't find one, we traverse through the set again.
    //Time Complexity: O(n).
    public boolean remove(E o){
        Node<E> current = new Node();
        current = firstNode;
        if (firstNode.element.equals(o)){
            firstNode = firstNode.next;
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
    
    //For contains method, we create a current node to store the location of the set we are traversing through.
    //We then traverse through the set, if the current element matches the user input, it then returns true, if not it traveres till it ends.
    //If there is no matches it then returns false.
    public boolean contains(E o){
        Node current = new Node();
        current = this.firstNode;
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
    
    //For get method, we create a current node to store the location of the set we are traversing through.
    //We then traverse through the set, if the current element matches the user input, it then returns the element, if not it travereses till it ends returning null if there is none.
    public E get(E o){
        Node<E> current = new Node();
        current = firstNode;
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
        LinkedSet<String> rappers = new LinkedSet<String>();
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
