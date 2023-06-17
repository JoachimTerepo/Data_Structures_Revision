package Revision;

public class NodeTree <E extends Comparable> implements Comparable <NodeTree> {

    E element;
    NodeTree left;
    NodeTree right;
    
    public NodeTree(){
        this.element = element;
        left = null;
        right = null;
    }

    public int compareTo(NodeTree t) {
        return element.compareTo(t.element);
    }
}
        
