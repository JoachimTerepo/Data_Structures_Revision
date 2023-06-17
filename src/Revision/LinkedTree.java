package Revision;

import java.util.List;

public class LinkedTree<E> {
    
    NodeTree root;
    NodeTree contains;
    int number_of_nodes;
    
    public LinkedTree()
    {
        this.root = null;
        this.number_of_nodes = 0;
    }
    
    public boolean add(E o)
    {        
        NodeTree newNode = new NodeTree();
        newNode.element = (Comparable) o;
        boolean isFound = false; //Checks if the Node is found and added to the Binary Tree.
        NodeTree current = root; //Created a Node which starts from the root of the Binary Tree.
        if(root == null){
            this.root = newNode; //If the root is null, the current Node that is added will be the root of the Binary Tree.
        }
        
        while (!isFound && current != null){
            int compare = newNode.compareTo(current); //Compares the newNode with the current Node.
            if (compare == 0){ //If the new Node is equal to the current Node, isFound becomes true,
                isFound = true; //and overwrite the new Node to current Node.
                current = newNode;
            }
            else if (compare > 0){ //If the newNode is larger than the current Node, move over to the right subtree.
                if (current.right == null){//If the right child is null, the new Node becomes the right child and isFound becomes true.
                    current.right = newNode;
                    isFound = true;
                }
                else{
                    current = current.right; //If there is a right child, traversed through the right child until null.
                }
            }
            else{
                if (current.left == null){ //If the newNode is smaller than the current Node, move over to the left subtree.
                    current.left = newNode; //If the left child is null, the new Node becomes the left child and isFound becomes true.
                    isFound = true;
                }
                else{
                    current = current.left; //If there is a left child, traversed through the left child until null.
                }
            }
        }
        number_of_nodes++;//Increments the number of nodes when added.
        return isFound;
    }
    
    public NodeTree get(NodeTree node){
        NodeTree current = root;
        boolean found = false;
        NodeTree foundNode = new NodeTree();
        while(!found && current!=null){ 
            int x= node.element.compareTo(current.element);
            if(x < 0)
                current = current.left;
            else if(x > 0)
                current = current.right;
            else
                found = true;
                foundNode = current;
        }
        return current;
    }
    
    private boolean contains(NodeTree node)
    {
        NodeTree current = root;
        boolean found = false;
        while(!found && current!=null){ 
            int x= node.element.compareTo(current.element);
            if(x < 0)
                current = current.left;
            else if(x > 0)
                current = current.right;
            else
                found = true;
        }
        return found;
    }
    
    //Returns a boolean, If the numElements = 0, that means there is nothing stored in the arraylist.
    //Thus, returning 0.
    public boolean isEmpty(){
        return (number_of_nodes == 0);
    }
    
    //Return's the number of elements, not the size of the array.
    public int size() {
        return number_of_nodes;
    }
    
    public List<E> inOrderTraversal(){ //public entry point
        List<E> values = (List<E>) new ArrayList<E>();
        recIOT(root, values);
        return values;
}
    private void recIOT(NodeTree current, List<E> values){ //private rec method
        if(current == null)
            return;
        recIOT(current.left, values);
        values.add((E) current.element);
        recIOT(current.right, values);
    }
    
    public List<E> preOrderTraversal(){ //public entry point
        List<E> values = (List<E>) new ArrayList<E>();
        recPOT(root, values);
        return values;
    }
    private void recPOT(NodeTree current, List<E> values){ //private rec method
        if(current == null)
            return;
        values.add((E) current.element);
        recPOT(current.left, values);
        recPOT(current.right, values);
    }
    
    public List<E> postOrderTraversal(){ //public entry point
        List<E> values = (List<E>) new ArrayList<E>();
        recPST(root, values);
        return values;
    }
    private void recPST(NodeTree current, List<E> values){ //private rec method
        if(current == null)
            return;
        recPST(current.left, values);
        recPST(current.right, values);
        values.add((E) current.element);
    }
    
}
