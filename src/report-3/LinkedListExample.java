/**
 * 
 */

import java.util.NoSuchElementException;


/**
 * 
 */
class Node {
    
    /* */
    int value;

    /* */
    Node next;

    /**
     * 
     * 
     * @param value
     * @param next
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}


/**
 * 
 */
class LinkedList {
    
    /* */
    Node root;

    /**
     * 
     */
    public LinkedList() {
        this.root = null;
    }

    /**
     * 
     * 
     * @param value
     */
    public void prepend(int value) {
        this.root = new Node(value, this.root);
    }
    
    /**
     * 
     * 
     * @param value
     */
    public void append(int value) {
        if (this.root == null) {
            this.root = new Node(value, null);
            return;
        }
        
        Node node = this.root;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(value, null);
    }
    
    /**
     * 
     * 
     * @return
     */
    public int first() {
        try {
            return this.root.value;
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }
    }
    
    /**
     * 
     * @return
     */
    public int last() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }

        Node node = this.root;
        while (node.next != null) {
            node = node.next;
        }
        return node.value;
    }
    
    /**
     * 
     */
    public String toString() {
        String s = "";
        Node node = this.root;

        while (node != null) {
            s += String.format("%d ", node.value);
            node = node.next;
        }
        return s.trim();
    }
    
    /**
     * 
     * 
     * @return
     */
    public int length() {
        Node n = this.root;
        int i = 0;
        while(n != null) {
            i += 1;
            n = n.next;
        }
        return i;
    }
}