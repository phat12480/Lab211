/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author ADMIN
 */
public class Node {

    public Object data;
    public Node next;

    public Node(Object x, Node p) {
        data = x;
        next = p;
    }

    public Node(Object x) {
        this(x, null);
    }

}
