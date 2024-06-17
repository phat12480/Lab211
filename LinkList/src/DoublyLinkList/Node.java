package DoublyLinkList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Node {

    int data;
    Node next;
    Node previous;
    //

    public Node() {
    }

    public Node(int data, Node previous, Node next) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    
    
    
}
